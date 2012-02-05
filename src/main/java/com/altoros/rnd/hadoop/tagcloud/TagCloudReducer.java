package com.altoros.rnd.hadoop.tagcloud;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class TagCloudReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        int tags = 0;
        for (IntWritable value : values) {
            tags += value.get();
        }
        context.write(key, new IntWritable(tags));
    }
}
