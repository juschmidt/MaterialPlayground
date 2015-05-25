package de.donjue.materialdesignone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

  String[] autocomplete_array = { "Android", "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "Ice Cream Sandwich",
      "Jelly Bean", "KitKat", "Lollipop" };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_array, android.R
        .layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    Spinner spinner = (Spinner) findViewById(R.id.sample_spinner);
    spinner.setAdapter(adapter);

    ArrayAdapter<String> autocompleteAdapter = new ArrayAdapter<>
        (this, android.R.layout.select_dialog_item, autocomplete_array);
    final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(
        R.id.sample_auto_complete_text_view);
    autoCompleteTextView.setAdapter(autocompleteAdapter);
    autoCompleteTextView.setThreshold(1);
    autoCompleteTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() {

      @Override
      public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
          ((AutoCompleteTextView) v).setText("");
        }
      }
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
