/*
 * Copyright 2013 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.launcher.util;

import java.util.Locale;

public enum OperatingSystem {

    UNIX("Unix"),
    LINUX("Linux"),
    SOLARIS("Solaris"),
    WINDOWS_XP("Windows XP"),
    WINDOWS_VISTA("Windows Vista"),
    WINDOWS_7("Windows 7"),
    WINDOWS_8("Windows 8"),
    WINDOWS_UNKNOWN("Windows"),
    MAC_OSX("Mac OS X"),
    MAC("Mac"),
    UNKNOWN("");

    private static final String PROPERTY_OS_NAME = "os.name";

    private final String identifier;

    private OperatingSystem(String system) {
        identifier = system.toLowerCase(Locale.ENGLISH);
    }

    public boolean isUnix() {
        return (this == UNIX) || (this == LINUX) || (this == SOLARIS);
    }

    public boolean isMac() {
        return (this == MAC_OSX) || (this == MAC);
    }

    public boolean isWindows() {
        return (this == WINDOWS_XP) || (this == WINDOWS_VISTA) || (this == WINDOWS_7) || (this == WINDOWS_8) || (this == WINDOWS_UNKNOWN);
    }

    /**
     * Should only be executed once at the start.
     */
    public static OperatingSystem getOS() {
        OperatingSystem best = UNKNOWN;
        final String os = System.getProperty(PROPERTY_OS_NAME).toLowerCase(Locale.ENGLISH);
        for (OperatingSystem system : values()) {
            if (os.contains(system.identifier) && (system.identifier.length() > best.identifier.length())) {
                best = system;
            }
        }
        return best;
    }
}
