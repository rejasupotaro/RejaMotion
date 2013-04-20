package com.rejasupotaro.rejamotionapp.test.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.test.AndroidTestCase;

import com.rejasupotaro.rejamotionapp.utils.ImageUtils;

public class ImageUtilsTest extends AndroidTestCase {

    public void testResize() throws Exception {
        Bitmap bitmap = Bitmap.createBitmap(640, 480, Config.RGB_565);

        {
            // scale down the image in box of the required size
            Bitmap resizedBitmap = ImageUtils.resize(bitmap, 300);
            assertEquals(300, resizedBitmap.getWidth());
        }
        {
            // scale down the image in box of the required size
            Bitmap resizedBitmap = ImageUtils.resize(bitmap, 800);
            assertEquals(800, resizedBitmap.getWidth());
        }
    }
}
