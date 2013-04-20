package com.rejasupotaro.rejamotionapp.test.utils;

import android.net.Uri;
import android.test.AndroidTestCase;

import com.rejasupotaro.rejamotionapp.utils.UriUtils;

public class UrlUtilsTest extends AndroidTestCase {

    public void testCompareDomain() throws Exception {
        Uri uri = Uri.parse("http://cookpad.com");

        // returns false if domain is null
        assertFalse(UriUtils.compareDomain(uri, null));

        // returns false if host of given uri is not the same as domain
        assertFalse(UriUtils.compareDomain(uri, "cookpad.com!"));
        assertFalse(UriUtils.compareDomain(uri, "cookpad.co"));

        // returns true if host of given uri is the same as domain
        assertTrue(UriUtils.compareDomain(uri, "cookpad.com"));
    }

}
