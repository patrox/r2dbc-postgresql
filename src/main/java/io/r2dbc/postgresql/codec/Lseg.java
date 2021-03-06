package io.r2dbc.postgresql.codec;

import io.r2dbc.postgresql.util.Assert;

import java.util.Objects;

/**
 * Value object that maps to the {@code lseg} datatype in Postgres.
 * <p>
 * Uses {@code double} to represent the coordinates.
 *
 * @since 0.8.5
 */
public final class Lseg {

    private final Point p1;

    private final Point p2;

    private Lseg(Point p1, Point p2) {
        this.p1 = Assert.requireNonNull(p1, "p1 must not be null");
        this.p2 = Assert.requireNonNull(p2, "p2 must not be null");
    }

    /**
     * Create a new {@link Lseg} given parameters {@link Point points } {@code p1} and {@code p2}.
     *
     * @param p1 first endpoint
     * @param p2 second endpoint
     * @return the new {@link Lseg} object
     * @throws IllegalArgumentException if {@code p1} or {@code p2} is {@code null}
     */
    public static Lseg of(Point p1, Point p2) {
        return new Lseg(p1, p2);
    }

    public Point getP1() {
        return this.p1;
    }

    public Point getP2() {
        return this.p2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lseg lseg = (Lseg) o;
        return this.p1.equals(lseg.p1) &&
            this.p2.equals(lseg.p2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.p1, this.p2);
    }

    @Override
    public String toString() {
        return String.format("[%s,%s]", this.p1, this.p2);
    }

}
