/*
 * Copyright (c) 2022 - The MegaMek Team. All Rights Reserved.
 *
 * This file is part of MekHQ.
 *
 * MekHQ is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MekHQ is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MekHQ. If not, see <http://www.gnu.org/licenses/>.
 */
package mekhq.campaign.personnel.enums;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormerSpouseReasonTest {
    @BeforeAll
    @SuppressWarnings(value = "ResultOfMethodCallIgnored")
    public static void beforeAll() {
        FormerSpouseReason.values();
    }

    //region Boolean Comparison Methods
    @Test
    public void testIsWidowed() {
        assertTrue(FormerSpouseReason.WIDOWED.isWidowed());
    }

    @Test
    public void testIsDivorce() {
        assertTrue(FormerSpouseReason.DIVORCE.isDivorce());
    }
    //endregion Boolean Comparison Methods

    //region File I/O
    @Test
    public void testParseFromString() {
        // Normal Parsing
        assertEquals(FormerSpouseReason.DIVORCE, FormerSpouseReason.parseFromString("DIVORCE"));
        assertEquals(FormerSpouseReason.WIDOWED, FormerSpouseReason.parseFromString("WIDOWED"));

        // Legacy Parsing
        assertEquals(FormerSpouseReason.DIVORCE, FormerSpouseReason.parseFromString("1"));
        assertEquals(FormerSpouseReason.WIDOWED, FormerSpouseReason.parseFromString("0"));

        // Error Case
        assertEquals(FormerSpouseReason.WIDOWED, FormerSpouseReason.parseFromString("blah"));
    }
    //endregion File I/O
}
