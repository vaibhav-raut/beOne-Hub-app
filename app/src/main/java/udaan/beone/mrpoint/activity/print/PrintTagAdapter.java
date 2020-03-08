package udaan.beone.mrpoint.activity.print;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.content.Context;
import android.print.PrintDocumentInfo;
import android.print.pdf.PrintedPdfDocument;
import android.graphics.pdf.PdfDocument;
import android.graphics.pdf.PdfDocument.PageInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import udaan.beone.mrpoint.R;
import udaan.beone.mrpoint.http.model.ItemTagM;

/**
 * Created by Vaibhav on 06-06-2016.
 */

public class PrintTagAdapter extends PrintDocumentAdapter {

    private Context context;
    private OnPrintJobFinish listener;
    private int pageHeight;
    private int pageWidth;
    public PdfDocument myPdfDocument;

    protected List<ItemTagM> toPrintItemTags;

    public int totalPages;
    private int stikersTotal;
    private int sticPrinted = 0;
    private int stikersXNo = 3;
    private int stikersYNo = 8;
    private int stikersPerTag = 1;
    private float fac = (float)(72.0/25.4);

    private float recW = 60.0f * fac; //mm - 63.83333333333333
    private float recH = 30.0f * fac; //mm - 34
    private float recR = 3.0f * fac;

//    private float sX = 2.85f * fac;
//    private float sY = 3.7f * fac;
    private float sX = 4.0f * fac;
    private float sY = 10.0f * fac;
    private float dX = 67.833f * fac;
    private float dY = 33.875f * fac;

    public PrintTagAdapter(Context context, OnPrintJobFinish listener, List<ItemTagM> toPrintItemTags, int stikersPerTag) {
        this.context = context;
        this.listener = listener;

        this.toPrintItemTags = toPrintItemTags;
        this.stikersPerTag = stikersPerTag;

        this.stikersTotal = (toPrintItemTags.size() * stikersPerTag);
        this.totalPages =  (stikersTotal / (stikersXNo * stikersYNo));
        this.totalPages +=  ((stikersTotal % (stikersXNo * stikersYNo)) > 0)? 1: 0;
    }

    @Override
    public void onLayout(PrintAttributes oldAttributes,
                         PrintAttributes newAttributes,
                         CancellationSignal cancellationSignal,
                         LayoutResultCallback callback,
                         Bundle metadata) {

        // Reset the Sticker Printed Count
        sticPrinted = 0;

        myPdfDocument = new PrintedPdfDocument(context, newAttributes);

        pageHeight = newAttributes.getMediaSize().getHeightMils()/1000 * 72;
        pageWidth = newAttributes.getMediaSize().getWidthMils()/1000 * 72;

        if (cancellationSignal.isCanceled() ) {
            callback.onLayoutCancelled();
            return;
        }

        if (totalPages > 0) {
            PrintDocumentInfo.Builder builder = new PrintDocumentInfo
                    .Builder("print_output.pdf")
                    .setContentType(PrintDocumentInfo.CONTENT_TYPE_DOCUMENT)
                    .setPageCount(totalPages);

            PrintDocumentInfo info = builder.build();
            callback.onLayoutFinished(info, true);
        } else {
            callback.onLayoutFailed("Page count is zero.");
        }
    }

    @Override
    public void onWrite(final PageRange[] pageRanges,
                        final ParcelFileDescriptor destination,
                        final CancellationSignal cancellationSignal,
                        final WriteResultCallback callback) {

        for (int i = 0; i < totalPages; i++) {
            if (pageInRange(pageRanges, i))
            {
                final PageInfo newPage = new PdfDocument.PageInfo.Builder(pageWidth, pageHeight, i).create();

                PdfDocument.Page page = myPdfDocument.startPage(newPage);

                if (cancellationSignal.isCanceled()) {
                    callback.onWriteCancelled();
                    myPdfDocument.close();
                    myPdfDocument = null;
                    return;
                }
                drawPage(page, i);
                myPdfDocument.finishPage(page);
            }
        }

        try {
            myPdfDocument.writeTo(new FileOutputStream(destination.getFileDescriptor()));
        } catch (IOException e) {
            callback.onWriteFailed(e.toString());
            return;
        } finally {
            myPdfDocument.close();
            myPdfDocument = null;
        }

        callback.onWriteFinished(pageRanges);
    }

    @Override
    public void onFinish() {
        listener.onPrintJobSuccess();
    }

    private boolean pageInRange(PageRange[] pageRanges, int page) {
        for (int i = 0; i < pageRanges.length; i++) {
            if ((page >= pageRanges[i].getStart()) && (page <= pageRanges[i].getEnd())) {
                return true;
            }
        }
        return false;
    }
    private void drawPage(PdfDocument.Page page, int pagenumber) {

        Canvas canvas = page.getCanvas();

        // Rectangle Paint
        Paint paintB = new Paint();
        paintB.setColor(Color.BLACK);
        Paint paintW = new Paint();
        paintW.setColor(Color.WHITE);
//        paintB.setStrokeWidth(5);

        // Stock Type Paint
        Paint paintStockType = new Paint();
        paintStockType.setColor(Color.BLACK);
        paintStockType.setTextSize(16);

        // Design No Paint
        Paint paintDesignNo = new Paint();
        paintDesignNo.setColor(Color.BLACK);
        paintDesignNo.setTextSize(14);

        // Stock MRP Title
        Paint paintMRP = new Paint();
        paintMRP.setColor(Color.BLACK);
        paintMRP.setTextSize(14);

        // Stock MRP Amount
        Paint paintMRPAm = new Paint();
        paintMRPAm.setColor(Color.BLACK);
        paintMRPAm.setTextSize(20);

        // Stock Stock Item Id
        Paint paintItemId = new Paint();
        paintItemId.setTypeface(Typeface.create("Arial",Typeface.BOLD_ITALIC));
        paintItemId.setColor(Color.BLACK);
        paintItemId.setTextSize(14);

        Bitmap myBitmap = BitmapFactory.decodeResource( context.getResources(), R.mipmap.udaan_logo);

        float spX = sX;
        float spY = sY;
        for(int y = 0; y < stikersYNo; y++) {
            for (int x = 0; (x < stikersXNo && sticPrinted < stikersTotal); x++, sticPrinted++) {

                // Draw Rounded Rectangle
                canvas.drawRoundRect(spX, spY, (spX + recW), (spY + recH), recR, recR, paintB);
                canvas.drawRoundRect((spX + 1), (spY + 1), (spX + recW - 1), (spY + recH - 1), recR, recR, paintW);

                ItemTagM itemTag = toPrintItemTags.get((int)(sticPrinted/stikersPerTag));

                // Draw Stock Type
                canvas.drawText(itemTag.getStockTypeName(), (spX + (2 * fac)), (spY + (7 * fac)), paintStockType);

                // Draw Design Number
                if(itemTag.getDesignNo() != null && !itemTag.getDesignNo().isEmpty()) {
                    canvas.drawText(itemTag.getDesignNo(), (spX + (2 * fac)), (spY + (12 * fac)), paintDesignNo);
                }

                // Draw Udaan Logo
                canvas.drawBitmap(myBitmap, null,
                        new RectF(((int)(spX + (40 * fac))),
                        ((int)(spY + (1 * fac))),
                        ((int)(spX + (59 * fac))),
                        ((int)(spY + (8 * fac)))), null);

                // Draw MRP Title
                canvas.drawText("MRP", (spX + (10 * fac)), (spY + (16 * fac)), paintMRP);

                // Draw MRP Amount
                canvas.drawText(itemTag.getDisMrpPriceAm().toString() + " ₹", (spX + (23 * fac)), (spY + (16 * fac)), paintMRPAm);

                // Draw Barcode Image
                String itemId = String.format("%08d", itemTag.getStockItemId());
                Bitmap barcodeBitmap = null;
                try {
                    barcodeBitmap = encodeAsBitmap(("UPI-" + itemId), BarcodeFormat.CODE_128, 500, 80);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
                canvas.drawBitmap(barcodeBitmap, null,
                        new RectF(((int)(spX + (5 * fac))),
                                ((int)(spY + (17 * fac))),
                                ((int)(spX + (55 * fac))),
                                ((int)(spY + (25 * fac)))), null);

                // Draw Stock Item Id
                canvas.drawText(itemId, (spX + (18 * fac)), (spY + (29 * fac)), paintItemId);

                spX += dX;
            }
            spX = sX;
            spY += dY;
        }
    }


    private static final int WHITE = 0xFFFFFFFF;
    private static final int BLACK = 0xFF000000;

    Bitmap encodeAsBitmap(String contents, BarcodeFormat format, int img_width, int img_height) throws WriterException {
        String contentsToEncode = contents;
        if (contentsToEncode == null) {
            return null;
        }
        Map<EncodeHintType, Object> hints = null;
        String encoding = guessAppropriateEncoding(contentsToEncode);
        if (encoding != null) {
            hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
            hints.put(EncodeHintType.CHARACTER_SET, encoding);
        }
        MultiFormatWriter writer = new MultiFormatWriter();
        BitMatrix result;
        try {
            result = writer.encode(contentsToEncode, format, img_width, img_height, hints);
        } catch (IllegalArgumentException iae) {
            // Unsupported format
            return null;
        }
        int width = result.getWidth();
        int height = result.getHeight();
        int[] pixels = new int[width * height];
        for (int y = 0; y < height; y++) {
            int offset = y * width;
            for (int x = 0; x < width; x++) {
                pixels[offset + x] = result.get(x, y) ? BLACK : WHITE;
            }
        }

        Bitmap bitmap = Bitmap.createBitmap(width, height,
                Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return bitmap;
    }

    private static String guessAppropriateEncoding(CharSequence contents) {
        // Very crude at the moment
        for (int i = 0; i < contents.length(); i++) {
            if (contents.charAt(i) > 0xFF) {
                return "UTF-8";
            }
        }
        return null;
    }

    public interface OnPrintJobFinish {
        public void onPrintJobSuccess();
        public void onPrintJobFailuer();
    }
}

