package ba.unsa.etf.rma.VJ_18182;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button dugme;
    private EditText tekst;
    private ListView lista;
    private ListaMuzicaraAdapter adapter;
    private ArrayList<Muzicar> listaMuzicara = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        napuniListu();
        dugme = (Button) findViewById(R.id.button);
        tekst = (EditText) findViewById(R.id.editText);
        lista = (ListView) findViewById(R.id.listView);
        Resources resources = getResources();
        adapter = new ListaMuzicaraAdapter(this, listaMuzicara, resources);
        lista.setAdapter(adapter);
        /*dugme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unosi.add(0, tekst.getText().toString());
                adapter.notifyDataSetChanged();
                tekst.setText("");
            }
        });*/
    }

    private void napuniListu() {
        listaMuzicara.add(new Muzicar("Nedeljko Bajić Baja", "Folk",
                "www.nedeljkobajicbaja.com",
                "Nedeljko Bajić Baja (9. juni 1968. Šipovo, Jugoslavija) je srbijanski " +
                        "pop-folk pjevač porijeklom iz Bosne i Hercegovine. ", "folk1"));
        listaMuzicara.add(new Muzicar("Zeljko Vasić", "Pop",
                "zeljkovasic.com", "Željko Vasić (rođen je 10. decembra 1979. " +
                "godine u Zaječaru) je srpski pop pevač, kompozitor i tekstopisac.", "pop1"));
        listaMuzicara.add(new Muzicar("Mladen Vojičić Tifa", "Rock", "",
                "Mladen Vojičić, poznatiji po svom nadimku Tifa, " +
                "(Sarajevo 17. listopada 1960.) bosanskohercegovački je rock pjevač. " +
                "Postao je poznat diljem Jugoslavije po svom kratkotrajnom boravku na mjestu pjevača " +
                "Bijelog dugmeta polovinom 1980-ih. Osim što je bio u Bijelom dugmetu, pjevao je u brojnim sastavima " +
                "s različitim stupnjevima uspješnosti " +
                "(Teška industrija, Vatreni poljubac i Divlje jagode). Danas, Tifa vodi solo karijeru.", "rock1"));

    }
}
