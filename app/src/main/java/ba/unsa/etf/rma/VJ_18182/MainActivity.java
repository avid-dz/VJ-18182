package ba.unsa.etf.rma.VJ_18182;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
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
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mojIntent = new Intent(MainActivity.this, PrikazDetaljaOMuzicaruActivity.class);
                mojIntent.putExtra("imeIPrezimeMuzicara", listaMuzicara.get(position).getImeIPrezime());
                mojIntent.putExtra("zanrMuzicara", listaMuzicara.get(position).getZanr());
                mojIntent.putExtra("biografijaMuzicara", listaMuzicara.get(position).getBiografija());
                mojIntent.putExtra("webStranicaMuzicara", listaMuzicara.get(position).getWebStranica());
                MainActivity.this.startActivity(mojIntent);
            }
        });
    }

    private void napuniListu() {
        ArrayList<String> listaTop5Pjesama0 = new ArrayList<>();
        listaTop5Pjesama0.add("Stare slike");
        listaTop5Pjesama0.add("Večita igra ljubavi");
        listaTop5Pjesama0.add("Rođen spreman");
        listaTop5Pjesama0.add("");
        listaTop5Pjesama0.add("");
        /*listaMuzicara.add(new Muzicar("Nedeljko Bajić Baja", "Folk",
                "www.nedeljkobajicbaja.com",
                "Nedeljko Bajić Baja (9. juni 1968. Šipovo, Jugoslavija) je srbijanski " +
                        "pop-folk pjevač porijeklom iz Bosne i Hercegovine. ", "folk1"));
        listaMuzicara.add(new Muzicar("Željko Vasić", "Pop",
                "zeljkovasic.com", "Željko Vasić (rođen je 10. decembra 1979. " +
                "godine u Zaječaru) je srpski pop pevač, kompozitor i tekstopisac.", "pop1"));
        listaMuzicara.add(new Muzicar("Mladen Vojičić Tifa", "Rock", "",
                "Mladen Vojičić, poznatiji po svom nadimku Tifa, " +
                "(Sarajevo 17. listopada 1960.) bosanskohercegovački je rock pjevač. " +
                "Postao je poznat diljem Jugoslavije po svom kratkotrajnom boravku na mjestu pjevača " +
                "Bijelog dugmeta polovinom 1980-ih. Osim što je bio u Bijelom dugmetu, pjevao je u brojnim sastavima " +
                "s različitim stupnjevima uspješnosti (Teška industrija, Vatreni poljubac i Divlje jagode). " +
                        "Danas, Tifa vodi solo karijeru.", "rock1"));*/

    }
}
