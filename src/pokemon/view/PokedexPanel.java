package pokemon.view;

import javax.swing.*;
import pokemon.controller.PokedexController;
import java.awt.event.*;
import java.awt.*;

public class PokedexPanel extends JPanel
{
	private PokedexController app;
	
	private JLabel numberLabel;
	private JLabel nameLabel;
	private JLabel evolveLabel;
	private JLabel attackLabel;
	private JLabel enhanceLabel;
	private JLabel healthLabel;
	private JLabel imageLabel;
	
	private JTextField numberField;
	private JTextField nameField;
	private JTextField evolveField;
	private JTextField attackField;
	private JTextField enhanceField;
	private JTextField healthField;
 	
	private SpringLayout appLayout;
	
	private JButton changeButton;
	private JComboBox pokedexDropdown;
	
	public PokedexPanel(PokedexController app)
	{
		super();
		
		this.app = app;
		appLayout = new SpringLayout();
		
		changeButton = new JButton("Change pokevalues");
		
		pokedexDropdown = new JComboBox(); //stub
		appLayout.putConstraint(SpringLayout.EAST, pokedexDropdown, -204, SpringLayout.EAST, this);
		numberLabel = new JLabel("Num");
		nameLabel = new JLabel("Name");
		evolveLabel = new JLabel("Evolve");
		attackLabel = new JLabel("Attack");
		enhanceLabel = new JLabel("Enhance");
		healthLabel = new JLabel("Health");
		imageLabel = new JLabel("Image");
		
		numberField = new JTextField("Num");
		nameField = new JTextField("Name");
		evolveField = new JTextField("Evolve");
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 1, SpringLayout.NORTH, evolveField);
		attackField = new JTextField("Attack");
		enhanceField = new JTextField("Enhance");
		healthField = new JTextField("Health");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(1000, 500));
		this.setBackground(Color.CYAN);
		
//		this.add(changeButton);
		this.add(pokedexDropdown);
		
		this.add(numberLabel);
		this.add(nameLabel);
		this.add(evolveLabel);
		this.add(attackLabel);
		this.add(enhanceLabel);
		this.add(healthLabel);
		this.add(imageLabel);
		this.add(numberField);
		this.add(nameField);
		this.add(evolveField);
		this.add(attackField);
		this.add(enhanceField);
		this.add(healthField);
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 48, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, numberLabel, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 48, SpringLayout.SOUTH, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, evolveLabel, 48, SpringLayout.SOUTH, nameLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolveLabel, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, attackLabel, 48, SpringLayout.SOUTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.WEST, attackLabel, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, enhanceLabel, 48, SpringLayout.SOUTH, attackLabel);
		appLayout.putConstraint(SpringLayout.WEST, enhanceLabel, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 48, SpringLayout.SOUTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, imageLabel, 48, SpringLayout.SOUTH, healthLabel);
		appLayout.putConstraint(SpringLayout.WEST, imageLabel, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, numberField, 0, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, numberField, 67, SpringLayout.EAST, enhanceLabel);
		appLayout.putConstraint(SpringLayout.NORTH, nameField, 49, SpringLayout.SOUTH, numberField);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 83, SpringLayout.EAST, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, evolveField, 49, SpringLayout.SOUTH, nameField);
		appLayout.putConstraint(SpringLayout.WEST, evolveField, 119, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, attackField, 49, SpringLayout.SOUTH, evolveField);
		appLayout.putConstraint(SpringLayout.WEST, attackField, 119, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, enhanceField, 49, SpringLayout.SOUTH, attackField);
		appLayout.putConstraint(SpringLayout.WEST, enhanceField, 78, SpringLayout.EAST, healthLabel);
		appLayout.putConstraint(SpringLayout.NORTH, healthField, 49, SpringLayout.SOUTH, enhanceField);
		appLayout.putConstraint(SpringLayout.WEST, healthField, 81, SpringLayout.EAST, imageLabel);
	}
	
	private void setupListeners()
	{
		
	}
	
}
