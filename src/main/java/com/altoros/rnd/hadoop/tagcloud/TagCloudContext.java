package com.altoros.rnd.hadoop.tagcloud;

import org.apache.hadoop.io.Text;

public interface TagCloudContext {

    static final Text TOTAL_TAGS_KEY = new Text("total tags");
}
