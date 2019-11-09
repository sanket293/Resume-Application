package com.sanketvagadiya.Activity;

import android.content.Context;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sanketvagadiya.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.MethodRule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import static org.junit.Assert.*;

public class MainActivityTest {



    @Test
    public void onCreate() {
        assertNotNull(R.id.nav_host_fragment);
        assertNotNull(R.id.nav_view);

    }
}