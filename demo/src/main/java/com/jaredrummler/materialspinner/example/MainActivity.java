/*
 * Copyright (C) 2016 Jared Rummler
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.jaredrummler.materialspinner.example;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class MainActivity extends AppCompatActivity {

  private static final String[] ANDROID_VERSIONS = {
      "Cupcake",
      "Donut",
      "Eclair",
      "Froyo",
      "Gingerbread",
      "Honeycomb",
      "Ice Cream Sandwich",
      "Jelly Bean",
      "KitKat",
      "Lollipop",
      "Marshmallow",
      "Nougat",
      "Oreo"
  };

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {

      @Override public void onClick(View view) {
        try {
          startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/jaredrummler/MaterialSpinner")));
        } catch (ActivityNotFoundException ignored) {
        }
      }
    });

    MaterialSpinner spinner = findViewById(R.id.spinner);
    spinner.setItems(ANDROID_VERSIONS);
    spinner.setText("");
    spinner.setHint("点击输入");

    spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

      @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
        Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
      }
    });
    spinner.setOnNothingSelectedListener(new MaterialSpinner.OnNothingSelectedListener() {

      @Override public void onNothingSelected(MaterialSpinner spinner) {
        Snackbar.make(spinner, "Nothing selected", Snackbar.LENGTH_LONG).show();
      }
    });
  }

}
