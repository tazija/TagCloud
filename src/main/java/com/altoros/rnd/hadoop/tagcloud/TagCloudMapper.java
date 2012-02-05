package com.altoros.rnd.hadoop.tagcloud;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

@SuppressWarnings({"unchecked"})
public class TagCloudMapper extends Mapper<LongWritable, Text, Text, IntWritable> implements TagCloudContext {

    public void map(LongWritable key, Text value, Mapper.Context context)
            throws IOException, InterruptedException {
        String line = value.toString();
        StringTokenizer tokenizer = new StringTokenizer(line, " \t\n\r\f");
        context.write(TOTAL_TAGS_KEY, new IntWritable(tokenizer.countTokens()));
        while (tokenizer.hasMoreTokens()) {
            Text tag = new Text(tokenizer.nextToken());
            context.write(tag, new IntWritable(1));
        }
    }
}