/*
 * WiFi Analyzer
 * Copyright (C) 2016  VREM Software Development <VREMSoftwareDevelopment@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.vrem.wifianalyzer.wifi.model;

import com.vrem.wifianalyzer.R;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SecurityTest {

    @Test
    public void testSecurity() throws Exception {
        assertEquals(5, Security.values().length);
    }

    @Test
    public void testImageResource() throws Exception {
        Assert.assertEquals(R.drawable.ic_lock_open_black_18dp, Security.NONE.imageResource());
        assertEquals(R.drawable.ic_lock_outline_black_18dp, Security.WPS.imageResource());
        assertEquals(R.drawable.ic_lock_outline_black_18dp, Security.WEP.imageResource());
        assertEquals(R.drawable.ic_lock_black_18dp, Security.WPA.imageResource());
        assertEquals(R.drawable.ic_lock_black_18dp, Security.WPA2.imageResource());
    }

    @Test
    public void testFindAll() throws Exception {
        List<Security> expected = Arrays.asList(Security.WPS, Security.WEP, Security.WPA, Security.WPA2);
        assertEquals(expected, Security.findAll("WPA-WPA2-WPA-WEP-WPS-WPA2"));
    }

    @Test
    public void testFindOne() throws Exception {
        assertEquals(Security.NONE, Security.findOne("xyz"));
        assertEquals(Security.NONE, Security.findOne(Security.NONE.name()));
        assertEquals(Security.WPS, Security.findOne(Security.WPS.name()));
        assertEquals(Security.WEP, Security.findOne(Security.WEP.name()));
        assertEquals(Security.WPA, Security.findOne(Security.WPA.name()));
        assertEquals(Security.WPA2, Security.findOne(Security.WPA2.name()));
    }

    @Test
    public void testOrder() throws Exception {
        Security[] expected = {Security.NONE, Security.WPS, Security.WEP, Security.WPA, Security.WPA2};
        assertArrayEquals(expected, Security.values());
    }
}