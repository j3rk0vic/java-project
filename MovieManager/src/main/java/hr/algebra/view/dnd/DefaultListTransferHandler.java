/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.view.dnd;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.TransferHandler;

/**
 *
 * @author ivanjerkovic
 */
public class DefaultListTransferHandler<T> extends TransferHandler {

    private final DataFlavor objectFlavor;

    private T transferData;

    public DefaultListTransferHandler(Class<T> clazz) {
        objectFlavor = new DataFlavor(clazz, clazz.getSimpleName());
    }

    @Override
    public int getSourceActions(JComponent c) {
        return COPY_OR_MOVE;
    }

    @Override
    protected Transferable createTransferable(JComponent c) {
        @SuppressWarnings("unchecked")
        JList<T> list = (JList<T>) c;
        transferData = list.getSelectedValue();

        return new Transferable() {
            @Override
            public DataFlavor[] getTransferDataFlavors() {
                return new DataFlavor[]{objectFlavor};
            }

            @Override
            public boolean isDataFlavorSupported(DataFlavor flavor) {
                return objectFlavor.equals(flavor);
            }

            @Override
            public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
                if (!isDataFlavorSupported(flavor)) {
                    throw new UnsupportedFlavorException(flavor);
                }
                return transferData;
            }
        };
    }

    @Override
    public boolean canImport(TransferSupport support) {
        return support.isDataFlavorSupported(objectFlavor);
    }

    @Override
    public boolean importData(TransferSupport support) {
        if (!canImport(support)) return false;

        try {
            @SuppressWarnings("unchecked")
            T data = (T) support.getTransferable().getTransferData(objectFlavor);

            JList.DropLocation dropLocation = (JList.DropLocation) support.getDropLocation();
            @SuppressWarnings("unchecked")
            JList<T> targetList = (JList<T>) support.getComponent();
            DefaultListModel<T> model = (DefaultListModel<T>) targetList.getModel();
            model.add(dropLocation.getIndex(), data);

            return true;

        } catch (UnsupportedFlavorException | IOException ex) {
            ex.printStackTrace();
        }

        return false;
    }
}
