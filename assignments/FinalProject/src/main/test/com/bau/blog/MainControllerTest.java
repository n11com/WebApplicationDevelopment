package com.bau.blog;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainControllerTest {

    private MainController controller = new MainController();

    @Test
    public void shouldReturnIndexPage() {
        assertThat(controller.index(), equalTo("index"));
    }
}