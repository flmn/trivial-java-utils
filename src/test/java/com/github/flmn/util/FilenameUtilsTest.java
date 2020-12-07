package com.github.flmn.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilenameUtilsTest {

    @Test
    void removeFileExtensions() {
        assertEquals("flmn", FilenameUtils.removeFileExtension("flmn", true));
        assertEquals("flmn", FilenameUtils.removeFileExtension("flmn", false));

        assertEquals("flmn", FilenameUtils.removeFileExtension("flmn.txt", true));
        assertEquals("flmn", FilenameUtils.removeFileExtension("flmn.txt", false));

        assertEquals(".flmn", FilenameUtils.removeFileExtension(".flmn", true));
        assertEquals(".flmn", FilenameUtils.removeFileExtension(".flmn", false));

        assertEquals(".flmn", FilenameUtils.removeFileExtension(".flmn.conf", true));
        assertEquals(".flmn", FilenameUtils.removeFileExtension(".flmn.conf", false));

        assertEquals("flmn", FilenameUtils.removeFileExtension("flmn.tar.gz", true));
        assertEquals("flmn.tar", FilenameUtils.removeFileExtension("flmn.tar.gz", false));

        assertEquals(".flmn", FilenameUtils.removeFileExtension(".flmn.conf.bak", true));
        assertEquals(".flmn.conf", FilenameUtils.removeFileExtension(".flmn.conf.bak", false));
    }
}