package com.differz.paychecker.core;

import java.util.Objects;

/*
 * https://habr.com/post/119400/
 */
public class Version implements Comparable {

    private int major;
    private int minor;
    private int release;
    private int assembly;

    public Version(int major, int minor, int release, int assembly) {
        this.major = major;
        this.minor = minor;
        this.release = release;
        this.assembly = assembly;
    }

    private int getMajor() {
        return major;
    }

    private int getMinor() {
        return minor;
    }

    private int getRelease() {
        return release;
    }

    private int getAssembly() {
        return assembly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Version version = (Version) o;
        return major == version.major &&
                minor == version.minor &&
                release == version.release &&
                assembly == version.assembly;
    }

    @Override
    public int hashCode() {
        return Objects.hash(major, minor, release, assembly);
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        }
        if (o == null || getClass() != o.getClass()) {
            return -1;
        }
        Version version = (Version) o;
        int cmp = major - version.getMajor();
        if (cmp != 0) {
            return cmp;
        }
        cmp = minor - version.getMinor();
        if (cmp != 0) {
            return cmp;
        }
        cmp = release - version.getRelease();
        if (cmp != 0) {
            return cmp;
        }
        return assembly - version.getAssembly();
    }

    @Override
    public String toString() {
        return "" + major +
                "." + minor +
                "." + release +
                "." + assembly;
    }
}
