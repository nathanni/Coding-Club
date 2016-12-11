package com.nathan.multithreading.web_crawler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by nni on 12/6/2016.
 */
public class webCrawler {

    LinkedList<String> urlQueue;
    LinkedList<String> htmlQueue;

    private Lock lock;
    private Condition noUrl;
    private Condition noHtml;

    public webCrawler() {
        this.lock = new ReentrantLock();
        noUrl = lock.newCondition();
        noHtml = lock.newCondition();
        urlQueue = new LinkedList<>();
        htmlQueue = new LinkedList<>();
    }


    public void webPageLoader() throws InterruptedException {

        while (true) {
            String url = null;
            try {
                lock.lock();
                while (urlQueue.size() == 0) {
                    noUrl.await();
                }

                url = urlQueue.removeFirst();
            } finally {
                lock.unlock();
            }
            //don't make this synchronized
            String html = getHtmlFromUrl(url);
            saveToDb(url, html);

            try {
                lock.lock();
                htmlQueue.add(html);
                noHtml.signalAll();
            } finally {
                lock.unlock();
            }

        }

    }


    public void urlExtractor() throws InterruptedException {
        while (true) {
            String html = null;

            try {
                lock.lock();
                while (htmlQueue.size() == 0) {
                    noHtml.await();
                }
                html = htmlQueue.removeFirst();


            } finally {
                lock.unlock();
            }
            List<String> urls = extractHtml(html);

            try {
                lock.lock();
                for (String url : urls) {
                    urlQueue.offer(url);
                }
                noUrl.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    private void saveToDb(String url, String html) {
    }

    private String getHtmlFromUrl(String url) {
        return "dummyHtml";
    }

    private List<String> extractHtml(String html) {
        return new ArrayList<>();
    }
}
