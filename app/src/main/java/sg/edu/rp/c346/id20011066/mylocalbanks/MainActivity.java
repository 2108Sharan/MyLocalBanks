package sg.edu.rp.c346.id20011066.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button btnDBS;
    Button btnOCBC;
    Button btnUOB;
    String btnClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDBS = findViewById(R.id.buttonDBS);
        registerForContextMenu(btnDBS);

        btnOCBC = findViewById(R.id.buttonOCBC);
        registerForContextMenu(btnOCBC);

        btnUOB = findViewById(R.id.buttonUOB);
        registerForContextMenu(btnUOB);


    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
        menu.add(0, 2, 2, "Toggle Favourite");

        if (v == btnDBS) {
            btnClicked = "DBS";
        } else if (v == btnOCBC) {
            btnClicked = "OCBC";
        } else {
            btnClicked = "UOB";
        }

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (btnClicked == "DBS") {
            if (item.getItemId() == 0) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentWeb);
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +"18001111111"));
                startActivity(intentCall);
            }

        } else if (btnClicked == "OCBC") {
            if (item.getItemId() == 0) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentWeb);
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +"18003633333"));
                startActivity(intentCall);
            }
        } else {
            if (item.getItemId() == 0) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentWeb);
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +"18002222121"));
                startActivity(intentCall);
            }
        }
        if(item.getItemId() == 2) {
            if (btnClicked == "DBS") {
                if(btnDBS.getCurrentTextColor() == Color.BLACK) {
                    btnDBS.setTextColor(Color.RED);
                }
            } else if (btnClicked == "OCBC") {
                if(btnOCBC.getCurrentTextColor() == Color.BLACK) {
                    btnOCBC.setTextColor(Color.RED);
                }
            } else {
                if(btnUOB.getCurrentTextColor() == Color.BLACK) {
                    btnUOB.setTextColor(Color.RED);
                }
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.EnglishSelection) {
            btnDBS.setText("DBS");
            btnOCBC.setText("OCBC");
            btnUOB.setText("UOB");
        } else if (id == R.id.ChineseSelection) {
            btnDBS.setText("星展银行");
            btnOCBC.setText("华侨银行");
            btnUOB.setText("大华银行");
        }


        return super.onOptionsItemSelected(item);
    }
}