package sg.edu.rp.c346.id21012612.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main, menu);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (item.getItemId() == 0) {
            tvDBS.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentDBS = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                    startActivity(intentDBS);
                    tvDBS.setText((CharSequence) intentDBS);
                }
            });
            tvOCBC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentOCBC = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                    startActivity(intentOCBC);
                    tvOCBC.setText((CharSequence) intentOCBC);
                }
            });

            tvUOB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentUOB = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                    startActivity(intentUOB);
                    tvUOB.setText((CharSequence) intentUOB);
                }
            });

        } else if (item.getItemId() == 1) {
            Intent intentDBS = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 1800" + 1111111));
            startActivity(intentDBS);
            tvDBS.setText((CharSequence) intentDBS);


            Intent intentOCBC = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 1800" + 3633333));
            startActivity(intentOCBC);
            tvOCBC.setText((CharSequence) intentOCBC);


            Intent intentUOB = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 1800" + 2222121));
            startActivity(intentUOB);
            tvUOB.setText((CharSequence) intentUOB);


        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        } else {
            tvDBS.setText("Error");
            tvOCBC.setText("Error");
            tvUOB.setText("Error");
        }

        return super.onOptionsItemSelected(item);
    }

}