# Proyecto De Interfaces

## Primer proyecto 

En este repositorio se manejan dos ramas la *master* y la *hotflix*. Y ahora cuenta con 5 actividades.

Las tres actividades anteriores eran el **Login**, el **Sign Up** y el **Main**.
Ahora cuenta con 4 actividades más el **Profile**, el **MainBab**, el **MainBn** y el **Splash**.

Ahora al abrir la aplicación nos saldrá el Activity Splash, ya que la animación principal de la aplicación.
### SPLASH:
![SPLASH_ACTIVITY](img/Splash1.png)
![SPLASH_ACTIVITY](img/Splash.png)
Cuenta con tres animaciones,dos para el icono de la app y uno para el texto y el icono.
La primera es de de zoom, es la que tiene el texto y el icono.

    <scale
    android:duration="3050"
    android:fillAfter="true"
    android:fromXScale="0"
    android:toXScale="2"
    android:fromYScale="0"
    android:toYScale="2"
    android:pivotX="50%"
    android:pivotY="50%" />

La segunda es la de giro que la tiene el icono :

    <rotate
    android:duration="3000"
    android:fillAfter="true"
    android:fromDegrees="0"
    android:pivotX="50%"
    android:pivotY="50%"
    android:toDegrees="360"/>

Y la ultima que es la de traslado :

    <translate
    android:duration="3000"
    android:fillAfter="true"
    android:fromXDelta="0"
    android:toXDelta="100"
    android:fromYDelta="0"
    android:toYDelta="600" />

Estas animaciones generan que la ventana de apertura de la app sea más dinámica.


### LOGIN:

![LOGIN_ACTIVITY](img/Login1.png)

Se consigue relacionar con **SignUp** mediante el siguiente código:

**En el Login.java :**

    public void openSignup(View view) {
        Intent intent = new Intent(Login.this, SignUp.class);
        startActivity(intent);
    }

**Y en el activity_login.xml :**

     <Button
        android:id="@+id/signup"
        android:text="SIGN UP"
        android:onClick="openSignup" <!--Desde aqui se llama al metodo para que
                                        al presionar el boton te mande a Sign Up-->
        app:cornerRadius="8dp"
        app:layout_constraintEnd_toEndOf="@id/guideline5"
        app:layout_constraintStart_toStartOf="@+id/guideline4"
        app:layout_constraintTop_toBottomOf="@id/login"
        style="@style/buttonStyle">
    </Button>



También se relacionan **Login** y **Main** por un codigo similar :

**En el Login.java :**

    public void openMain(View view) {
        Intent intent = new Intent(Login.this, Main.class);
        startActivity(intent);
    }

**Y en el activity_login.xml :**

        android:onClick="openMain"


### SIGN UP:

![SIGNUP_ACTIVITY](img/SignUp1.png)

El SignUp cuenta con dos botones, *Confirm* y *Cancel* .El primero te mandara al **Main** y el segundo al **Login**
El código es el siguiente:

**Para ir al Login**

*SignUp.java*
        
    public void returnLogin(View view) {
        Intent intent = new Intent(SignUp.this, Login.class);
        startActivity(intent);
    }
    
*activity_signup.xml*
    
    android:id="@+id/cancelar"
    android:text="@string/cancel"
    android:onClick="returnLogin"

**Para ir al Main**

*SignUp.java*

     public void returnMain(View view) {
        Intent intent = new Intent(SignUp.this, Main.class);
        startActivity(intent);
    }

*activity_signup.xml*

    android:id="@+id/confirm"
    android:text="CONFIRM"
    app:cornerRadius="0dp"
    android:onClick="returnMain"


### MAIN:

![MAIN_ACTIVITY](img/Main1.png)
![MAIN_ACTIVITY](img/Main2.png)
Hemos creado un WebView y tambien implementamos un ActionBar y que tras presionar la última opcion te saldra un AlertDialogBuilder.
Si seleccionas Scrolling volveras al Login.

### MAINBAB :
![MAINBAB_ACTIVITY](img/MainBar.jpg)
Hemos creado un activity donde se implementa un ActionBab con su bottomBar que es un boton en el centro con una funcion en especifico y se ve la dinamica, para ello implementamos este codigo en el *activity_main_bab.xml* :
        
        <com.google.android.material.bottomappbar.BottomAppBar
            android:id="@+id/bottom_app_bar"
            android:layout_width="match_parent"
            android:layout_height="63dp"
            android:layout_gravity="bottom"
            app:fabAlignmentMode="center"
            app:fabAnchorMode="cradle"
            app:fabCradleMargin="10dp"
            app:menu="@menu/bottom_app_bar_menu"
            app:navigationIcon="@drawable/baseline_add_24" />

        <com.google.android.material.floatingactionbutton.FloatingActionButton
            android:id="@+id/fab"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:backgroundTint="@color/fucsia_200"
            android:src="@drawable/ajuste"
            app:fabSize="normal"
            app:layout_anchor="@+id/bottom_app_bar"
            app:tint="@android:color/white">

        </com.google.android.material.floatingactionbutton.FloatingActionButton>

Y en el *MainBab.java* :

        BottomAppBar bottomAppBar = findViewById(R.id.bottom_app_bar);
        FloatingActionButton myfab = findViewById(R.id.fab);
        myfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainBab.this,"Fab Clicked",Toast.LENGTH_SHORT).show();}
        });
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainBab.this,"Menu clicked",Toast.LENGTH_SHORT).show();}
        });
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.heart) {
                    Toast.makeText(MainBab.this,"Added to favourites",Toast.LENGTH_SHORT).show();
                }
                if(id == R.id.lenguaje) {
                    Toast.makeText(MainBab.this,"Beginning search",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

### MAINBN: 
![MAINBN_ACTIVITY](img/MainBn.jpg)
Tambien se implemento un MainBn en donde solo hay un actionbar y esta hecha con fragments, por lo que al presionar en las items del menu te cambia de fragment,
dependiendo de la item seleccionada.
Para ello se crearon 4 fragments y una clase java extra llamada SectionPageAdapter que tiene :

        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new Page1();
                case 1:
                    return new Page2();
                case 2:
                    return new Page4();
                default:
                    return null;
            }
        }

