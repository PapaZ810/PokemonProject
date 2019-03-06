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
	private JButton saveButton;
	private JComboBox<String> pokedexDropdown;
	
	private ImageIcon pokemonIcon;
	
	public PokedexPanel(PokedexController app)
	{
		super();
		
		this.app = app;
		this.appLayout = new SpringLayout();
		this.pokemonIcon = new ImageIcon(getClass().getResource("/pokemon/view/images/arcanine.jpeg"));
		
		changeButton = new JButton("Change pokevalues");
		saveButton = new JButton("Save");
		pokedexDropdown = new JComboBox<String>();
		
		numberLabel = new JLabel("This pokemon number is");
		nameLabel = new JLabel("This pokemon name is");
		evolveLabel = new JLabel("This pokemon can evolve");
		attackLabel = new JLabel("This pokemon attack level is");
		enhanceLabel = new JLabel("This pokemon enhancement level is");
		healthLabel = new JLabel("This pokemon health is");
		imageLabel = new JLabel("Images here", pokemonIcon, JLabel.CENTER);
		
		numberField = new JTextField("0");
		nameField = new JTextField("My pokename");
		evolveField = new JTextField("false");
		attackField = new JTextField("0");
		enhanceField = new JTextField("0");
		healthField = new JTextField("0");
		
		setupDropdown();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupDropdown()
	{
		DefaultComboBoxModel<String> temp = new DefaultComboBoxModel<String>(app.buildPokedexText());
		pokedexDropdown.setModel(temp);
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(800, 600));
		this.setBackground(new Color(0, 153, 153));
		
		this.add(changeButton);
		this.add(saveButton);
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
		
		imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
		imageLabel.setHorizontalTextPosition(JLabel.CENTER);
	}
	
	private void sendDataToController()
	{
		int index = pokedexDropdown.getSelectedIndex();
		
		if(app.isInt(attackField.getText()) && app.isDouble(enhanceField.getText()) && app.isInt(healthField.getText())) 
		{
			String [] data = new String[5];
			
			//code
			
			app.updatePokemon(index, data);
		}
	}
	
	private void updateFields(int index)
	{
		String [] data = app .getPokeData(index);
		
		attackField.setText(data[0]);
		enhanceField.setText(data[1]);
		healthField.setText(data[2]);
		nameField.setText(data[3]);
		evolveField.setText(data[4]);
		numberField.setText(data[5]);
	}
	
	private void changeImageDisplay(String name)
	{
		String path = "/pokemon/view/images/";
		String defaultName = "pokeball";
		String extension = ".png";
		
		try 
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + name.toLowerCase() + extension));
		}
		catch (NullPointerException missingFile)
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		imageLabel.setIcon(pokemonIcon);
		repaint();
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 132, SpringLayout.EAST, changeButton);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, -59, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, changeButton, 0, SpringLayout.NORTH, saveButton);
		appLayout.putConstraint(SpringLayout.WEST, changeButton, 99, SpringLayout.EAST, pokedexDropdown);
		appLayout.putConstraint(SpringLayout.SOUTH, attackField, -50, SpringLayout.NORTH, enhanceField);
		appLayout.putConstraint(SpringLayout.NORTH, enhanceField, -5, SpringLayout.NORTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.WEST, enhanceField, 0, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.EAST, enhanceField, 0, SpringLayout.EAST, numberField);
		appLayout.putConstraint(SpringLayout.NORTH, healthField, -5, SpringLayout.NORTH, healthLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthField, 0, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.EAST, healthField, -114, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, evolveField, -50, SpringLayout.NORTH, attackField);
		appLayout.putConstraint(SpringLayout.NORTH, attackField, -5, SpringLayout.NORTH, attackLabel);
		appLayout.putConstraint(SpringLayout.WEST, attackField, 0, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.EAST, attackField, 0, SpringLayout.EAST, numberField);
		appLayout.putConstraint(SpringLayout.NORTH, numberField, 32, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, numberField, -114, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, evolveLabel, -237, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, nameLabel, -254, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, numberLabel, -240, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, nameField, -48, SpringLayout.NORTH, evolveField);
		appLayout.putConstraint(SpringLayout.NORTH, evolveField, -5, SpringLayout.NORTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolveField, 0, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.EAST, evolveField, -92, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, nameField, 121, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, nameField, -35, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, numberField, -62, SpringLayout.NORTH, nameField);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 0, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.WEST, imageLabel, 30, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, imageLabel, -82, SpringLayout.WEST, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, pokedexDropdown, 30, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, pokedexDropdown, -61, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 47, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 61, SpringLayout.SOUTH, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, evolveLabel, 61, SpringLayout.SOUTH, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, attackLabel, 61, SpringLayout.SOUTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.EAST, attackLabel, -216, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, enhanceLabel, 61, SpringLayout.SOUTH, attackLabel);
		appLayout.putConstraint(SpringLayout.EAST, enhanceLabel, -171, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 61, SpringLayout.SOUTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.EAST, healthLabel, -249, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, imageLabel, 0, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, imageLabel, 271, SpringLayout.NORTH, numberLabel);
	}
	
	private void setupListeners()
	{
		changeButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{
					sendDataToController();
				}
			});
		
		saveButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent click)
					{
						app.savePokedex();
					}
				});
		
		pokedexDropdown.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent selection)
				{
					String name = pokedexDropdown.getSelectedItem().toString();
					updateFields(pokedexDropdown.getSelectedIndex());
					changeImageDisplay(name);
				}
			});
	}
	
}
