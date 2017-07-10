package org.fanlychie.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by fanlychie on 2017/7/10.
 */
@Component
@ConfigurationProperties("layout")
public class LayoutConfig {

    private String desc;

    private List<Moudle> moudles;

    private int[] backgroundRgb;

    private List<String> tagCloudRandomColors;

    private Map<String, String> moudleColorMapping;

    private Author author;

    public static class Moudle {

        private String width;

        private String height;

        private String desc;

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            return "{" +
                    "width=" + width +
                    ", height=" + height +
                    ", desc='" + desc + '\'' +
                    '}';
        }

    }

    public static class Author {

        private String name;

        private String mail;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", mail='" + mail + '\'' +
                    '}';
        }

    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Moudle> getMoudles() {
        return moudles;
    }

    public void setMoudles(List<Moudle> moudles) {
        this.moudles = moudles;
    }

    public int[] getBackgroundRgb() {
        return backgroundRgb;
    }

    public void setBackgroundRgb(int[] backgroundRgb) {
        this.backgroundRgb = backgroundRgb;
    }

    public List<String> getTagCloudRandomColors() {
        return tagCloudRandomColors;
    }

    public void setTagCloudRandomColors(List<String> tagCloudRandomColors) {
        this.tagCloudRandomColors = tagCloudRandomColors;
    }

    public Map<String, String> getMoudleColorMapping() {
        return moudleColorMapping;
    }

    public void setMoudleColorMapping(Map<String, String> moudleColorMapping) {
        this.moudleColorMapping = moudleColorMapping;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "LayoutConfig{" +
                "desc='" + desc + '\'' +
                ", moudles=" + moudles +
                ", backgroundRgb=" + Arrays.toString(backgroundRgb) +
                ", tagCloudRandomColors=" + tagCloudRandomColors +
                ", moudleColorMapping=" + moudleColorMapping +
                ", author=" + author +
                '}';
    }

}