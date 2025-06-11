/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.parsers.rss;

import hr.algebra.factory.ParseFactory;
import hr.algebra.factory.UrlConnnectionFactory;
import hr.algebra.model.Movie;
import hr.algebra.utilities.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author ivanjerkovic
 */
// strogotipizirani parser
// radit cu sa strogo tipiziranim enumom -> item, title, ...
public class MovieParser {

    private static void uploadPicture(Movie movie, String source) {
        try {
            //https://static.slobodnadalmacija.hr/images/slike/2025/05/10/29401010.jpg
            String ext = source.substring(source.lastIndexOf("."));
            // osiguravanje da ako nije nikakva extension da bar bude "jpg"
            if (ext.length() > 4) {
                ext = EXT;
            }
            String name = UUID.randomUUID() + ext;
            String destination = DIR + File.separator + name;

            FileUtils.copyFromUrl(source, destination);

            movie.setPicturePath(destination);
        } catch (Exception ex) {
            Logger.getLogger(MovieParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private enum Tag {
        ITEM("item"),
        TITLE("title"),
        LINK("link"),
        DESC("description"),
        ENC("enclosure"),
        PUB_DATE("pubDate");

        private final String value;

        private Tag(String value) {
            this.value = value;
        }

        // pametno mapira string na tag
        public static Optional<Tag> from(String value) {
            // for -> ako je to taj daj mu ga
            for (Tag tag : values()) {
                if (tag.value.equals(value)) {
                    return Optional.of(tag);
                }
            }
            return Optional.empty(); // ako value ne pase priskaci, item more, link more, priskaci, priskaci...
        }

    }

    // private static final String RSS_URL = "https://slobodnadalmacija.hr/feed";
    private static final String RSS_URL = "https://www.moviefone.com/feeds/what-to-watch.rss";
    private static final String ATTRIBUTE_URL = "url";
    private static final String EXT = ".jpg";
    private static final String DIR = "assets";

    // 1. korak -> otvorit konekciju na internet
    // 2. korak -> napravit event reader
    public static List<Movie> parse() throws Exception {
        List<Movie> movies = new ArrayList<>();

        // otvaranje konekcije:
        HttpURLConnection con = UrlConnnectionFactory.getHttpUrlConnection(RSS_URL);

        // ovo kaze: daj mi string podataka da ih pocnen citat (otvoren stream)
        try (InputStream is = con.getInputStream()) {
            XMLEventReader reader = ParseFactory.createStaxParser(is);

            // jos uvik nije naletija tag koji mene zanima:
            Optional<Tag> tag = Optional.empty();

            // jos uvik article nije nasta jer nisan naletija na itema, tek kad naletin na itema postojat ce article
            Movie movie = null;

            // kad parser starta, nista nije zadano. nema taga u obradi, nema articla, nema startElementa 
            StartElement startElement = null;

            // dok god reader ima evenata, daj event -> pull parser
            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        startElement = event.asStartElement();
                        String name = startElement.getName().getLocalPart();
                        // System.out.println(name); -> isprinta tagove samo za test
                        tag = Tag.from(name);
                        // svaki put kad naleti item to je neko ko me zanima i to je tocno item, tad cu napravit article i gurnit cu ga u listu:
                        if (tag.isPresent() && tag.get().equals(Tag.ITEM)) {
                            movie = new Movie();
                            movies.add(movie);
                        }

                        // enc je self-closing
                        if (tag.isPresent() && tag.get().equals(Tag.ENC) && movie != null) {
                            Attribute att = startElement.getAttributeByName(new QName(ATTRIBUTE_URL));
                            if (att != null) {
                                // System.out.println("Found image URL: " + att.getValue()); -> log samo da provjerin da su se ucitale slike kako triba
                                uploadPicture(movie, att.getValue());
                            }
                        }
                        
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        // citan tag koji me zanima
                        if (tag.isPresent() && movie != null) { // ovo mi osigurava da nisan na sigurnon mistu. npr. ako ima <channel> <title>. taj title me ne zanima. al ako ide <item> <title>, taj title me zanima
                            // sad san izvuka podatke vanka
                            String data = event
                                    .asCharacters()
                                    .getData()
                                    .trim();

                            switch (tag.get()) {
                                case TITLE:
                                    // podaci postoje:
                                    if (!data.isEmpty()) {
                                        movie.setTitle(data);
                                    }
                                    break;
                                case LINK:
                                    movie.setLink(data);
                                    break;

                                case DESC:
                                    if (!data.isEmpty()) {
                                        movie.setDescription(data);
                                    }
                                    break;
                                case PUB_DATE:
                                    if (!data.isEmpty()) {
                                        try {
                                            DateTimeFormatter rssFormatter = DateTimeFormatter.RFC_1123_DATE_TIME;
                                            movie.setPublishedDate(LocalDateTime.parse(data, rssFormatter));
                                        } catch (Exception e) {
                                            Logger.getLogger(MovieParser.class.getName()).log(Level.WARNING, "Could not parse pubDate" + data, e);
                                            movie.setPublishedDate(LocalDateTime.now());
                                        }
                                    }
                            }

                        }
                        break;
                }
            }
        }

        return movies;
    }

    // staticka klasa
    private MovieParser() {
    }

}
