package model;

import java.awt.image.BufferedImage;

public class Histogram {
    private int[] values = new int[256];
    private int[] normalizedValues = new int[256];
    private int[] valuesCum = new int [256];
    private float normalizationFactor;
    BufferedImage image;

    public int[] getNormalizedValues() {
        return normalizedValues;
    }

    public Histogram(BufferedImage image) {
        this.image = image;
        this.normalizationFactor = 256 / (image.getWidth() * image.getHeight());
        getHistogramValues();
        normalizeCumHistogram();
    }

    private void normalizeCumHistogram() {
        valuesCum[0] = (int) normalizationFactor * values[0];
        for (int i = 1; i < values.length; i++) {
            valuesCum[i] = (int) (valuesCum[i - 1] + normalizationFactor * values[i]);
        }
    }

    private void normalizeValues() {
        for (int i = 0; i < values.length; i++) {
            normalizedValues[i] = (int) normalizationFactor * values[i];
        }
    }


    public void getHistogramValues() {
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                int value = image.getRGB(j, i);
                value = value & 0xff;
                values[value]++;
            }
        }
    }

    public int[] getValues() {
        return values;
    }

    public void setValues(int[] values) {
        this.values = values;
    }
}
