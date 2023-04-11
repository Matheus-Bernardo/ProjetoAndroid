package com.example.faitecoriginal;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	List<String> opcoes;
	ArrayAdapter<String> adaptador;
	ListView lvOpcoes;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lvOpcoes = (ListView) findViewById(R.id.lvopcoes);
		
		opcoes = new ArrayList<String>();
		
		opcoes.add("Nova meta");
		opcoes.add("Motivações");
		opcoes.add("Sobre");
		opcoes.add("Sair");
		
		adaptador = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,opcoes);
		lvOpcoes.setAdapter(adaptador);
		lvOpcoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
				switch (position){
                case 0: criarMetas();
                    break;
                case 1: motivacao();
                    break;
                case 2: exibirSobre();
                    break;
                case 3: finish();
                    break;
            }
				
			}
		});
		
		
	}

	

	
	
	  private void exibirSobre() {
	        Intent it = new Intent(MainActivity.this, Sobre.class);
	        startActivity(it);
	    }
	  
	  private void motivacao() {
	        Intent it = new Intent(this,Motivacao.class);
	        startActivity(it);
	        
	        		
	    }
	  
	  private void criarMetas() {
		  Intent it = new Intent(this,CriarMetas.class);
		  startActivity(it);
	    }
}
