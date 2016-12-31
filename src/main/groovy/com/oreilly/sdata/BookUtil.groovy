package com.oreilly.sdata

import java.util.concurrent.ThreadLocalRandom

/**
 * Created by oo185005 on 12/30/16.
 */
class BookUtil {
    static List<String> titles = ['Don Quixote', '1984', 'Adventures of Huckleberry Finn', 'Ulysses', 'The Great Gatsby', 'On the Road',
                  'Catch 22', 'To Kill A Mockingbird', 'Brave New World', 'The Scarlet letter']

    static List<Book> create(int size) {
        (0..size).collect {create()}
    }

    static Book create() {
        new Book().with {
            title = titles[ThreadLocalRandom.current().nextInt(1, titles.size())]
            pageCount =ThreadLocalRandom.current().nextInt(100, 151)
            publishDate = new Date()
            price = 15.50

            it
        }
    }
}
