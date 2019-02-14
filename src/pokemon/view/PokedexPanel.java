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
	private JComboBox<String> pokedexDropdown;
	
	private ImageIcon pokemonIcon;
	
	public PokedexPanel(PokedexController app)
	{
		super();
		
		this.app = app;
		this.appLayout = new SpringLayout();
		this.pokemonIcon = new ImageIcon(getClass().getResource("/pokemon/view/images/arc/jpeg"));
		
		changeButton = new JButton("Change pokevalues");
		pokedexDropdown = new JComboBox<String>();
		
		numberLabel = new JLabel("This pokemon number is");
		nameLabel = new JLabel("This pokemon name is");
		evolveLabel = new JLabel("This pokemon can evolve");
		attackLabel = new JLabel("This pokemon attack level is");
		enhanceLabel = new JLabel("This pokemon enhancement level is");
		healthLabel = new JLabel("This pokemon health is");
		imageLabel = new JLabel("0", pokemonIcon, JLabel.CENTER);
		
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
		sendDataToController();
		changeImageDisplay("name");
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
	
	private void changeImageDisplay(String name)
	{
		String path = "/pokemon/view/images/";
		String defaultName = "arc";
		String extension = ".jpeg";
		
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
		appLayout.putConstraint(SpringLayout.EAST, pokedexDropdown, -204, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 1, SpringLayout.NORTH, evolveField);
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
		
		pokedexDropdown.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent selection)
				{
					String name = pokedexDropdown.getSelectedItem().toString();
					changeImageDisplay(name);
				}
			});
	}
	
}
