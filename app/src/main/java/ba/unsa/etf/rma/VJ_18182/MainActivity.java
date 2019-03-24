package ba.unsa.etf.rma.VJ_18182;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button dugme;
    private EditText tekst;
    private ListView lista;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dugme = (Button) findViewById(R.id.button);
        tekst = (EditText) findViewById(R.id.editText);
        lista = (ListView) findViewById(R.id.listView);
        final ArrayList<String> unosi = new ArrayList<>();
        adapter = new ArrayAdapter<>
                (this, R.layout.element_liste, R.id.Itemname, unosi);
        lista.setAdapter(adapter);
        dugme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unosi.add(0, tekst.getText().toString());
                adapter.notifyDataSetChanged();
                tekst.setText("");
            }
        });
    }
}
