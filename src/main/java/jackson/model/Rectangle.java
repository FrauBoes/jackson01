package jackson.model;

import java.util.Objects;

public class Rectangle {

    private int height;
    private int width;
    private int x;
    private int y;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return height == rectangle.height && width == rectangle.width && x == rectangle.x && y == rectangle.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width, x, y);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("***** Rectangle Details *****\n");
        sb.append("Width=" + getWidth() + "\n");
        sb.append("Height=" + getHeight() + "\n");
        sb.append("X=" + getX() + "\n");
        sb.append("Y=" + getY() + "\n");
        sb.append("*****************************");
        return sb.toString();
    }
}
