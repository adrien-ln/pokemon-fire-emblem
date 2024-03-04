package pokemon;

import pokemon.vue.Vue;
import java.awt.*;

public class Lanceur {
    public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			Vue vue=new Vue();
			vue.pack();
			vue.setVisible(true);
		});
	}
}
