package a4c.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);



        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        List<Food> food = new ArrayList<>();
        food.add(new Food("Полезная пища", "Фрукты, овощи"," уопиоукпршуки миукриукиагукиопку"));
        food.add(new Food("Полезная пища", "Фрукты, овощи"," уопиоукпршуки миукриукиагукиопку"));
        food.add(new Food("Полезная пища", "Фрукты, овощи"," уопиоукпршуки миукриукиагукиопку"));
        food.add(new Food("Полезная пища", "Фрукты, овощи"," уопиоукпршуки миукриукиагукиопку"));
        food.add(new Food("Полезная пища", "Фрукты, овощи"," уопиоукпршуки миукриукиагукиопку"));
        food.add(new Food("Полезная пища", "Фрукты, овощи"," уопиоукпршуки миукриукиагукиопку"));
        food.add(new Food("Полезная пища", "Фрукты, овощи"," уопиоукпршуки миукриукиагукиопку"));
        food.add(new Food("Полезная пища", "Фрукты, овощи"," уопиоукпршуки миукриукиагукиопку"));
        food.add(new Food("Полезная пища", "Фрукты, овощи"," уопиоукпршуки миукриукиагукиопку"));
        food.add(new Food("Полезная пища", "Фрукты, овощи"," уопиоукпршуки миукриукиагукиопку"));



        recyclerView.setLayoutManager(layoutManager);

        final RecyclerView.Adapter cityad = new cityAdapter(food);

        recyclerView.setAdapter(cityad);



    }


    class cityAdapter extends RecyclerView.Adapter<foodViewHolder> {


        private List<Food> foods;

        public cityAdapter(List<Food> foods) {
            this.foods = foods;
        }

        @Override
        public foodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View rowView = layoutInflater.inflate(R.layout.activity_main,parent,false);
            return new foodViewHolder(rowView);
        }

        @Override
        public void onBindViewHolder(final foodViewHolder holder, final int position) {

           holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, position + " ",Toast.LENGTH_SHORT).show();
                    holder.relativeLayout.setBackgroundColor(getResources().getColor(R.color.yellow));
                }
           });

            holder.mainText.setText(foods.get(position).name);
            holder.lastMainText.setText(foods.get(position).lastName);
            holder.text.setText(foods.get(position).text);

            holder.like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   int a = Integer.valueOf(holder.count.getText().toString());
                    a+=1;
                    holder.count.setText(String.valueOf(a));
                }
            });

            holder.disLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int a = Integer.valueOf(holder.count.getText().toString());
                    a-=1;
                    holder.count.setText(String.valueOf(a));
                }
            });
        }

        @Override
        public int getItemCount() {
            return foods.size();
        }
    }


    public class foodViewHolder extends RecyclerView.ViewHolder {

        public TextView count;
        public TextView mainText;
        public TextView lastMainText;
        public TextView text;
        public Button like;
        public Button disLike;
        public RelativeLayout relativeLayout;

        public foodViewHolder(View itemView) {
            super(itemView);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.activity_main);
            count = (TextView) itemView.findViewById(R.id.count);
            mainText = (TextView) itemView.findViewById(R.id.main);
            lastMainText = (TextView) itemView.findViewById(R.id.lastmain);
            text = (TextView) itemView.findViewById(R.id.text);
            like = (Button) itemView.findViewById(R.id.like);
            disLike = (Button) itemView.findViewById(R.id.dislike);
        }
    }

    class Food {
        String name;
        String lastName;
        String text;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Food(String name, String lastName, String text) {

            this.name = name;
            this.lastName = lastName;
            this.text = text;
        }
    }
}
