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
		this.pokemonIcon = new ImageIcon(getClass().getResource("/pokemon/view/images/arc.jpeg"));
		
		changeButton = new JButton("Change pokevalues");
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
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 1, SpringLayout.NORTH, changeButton);
		appLayout.putConstraint(SpringLayout.WEST, pokedexDropdown, 30, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 47, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 61, SpringLayout.SOUTH, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, evolveLabel, 61, SpringLayout.SOUTH, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, attackLabel, 61, SpringLayout.SOUTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.EAST, attackLabel, -216, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, enhanceLabel, 61, SpringLayout.SOUTH, attackLabel);
		appLayout.putConstraint(SpringLayout.EAST, enhanceLabel, -171, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 61, SpringLayout.SOUTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.EAST, healthLabel, -249, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, numberField, 48, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, numberField, -10, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, nameLabel, -146, SpringLayout.WEST, nameField);
		appLayout.putConstraint(SpringLayout.EAST, numberLabel, -132, SpringLayout.WEST, nameField);
		appLayout.putConstraint(SpringLayout.NORTH, nameField, 63, SpringLayout.SOUTH, numberField);
		appLayout.putConstraint(SpringLayout.EAST, nameField, -10, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, evolveLabel, -186, SpringLayout.WEST, evolveField);
		appLayout.putConstraint(SpringLayout.NORTH, evolveField, 63, SpringLayout.SOUTH, nameField);
		appLayout.putConstraint(SpringLayout.EAST, evolveField, -10, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, attackField, 63, SpringLayout.SOUTH, evolveField);
		appLayout.putConstraint(SpringLayout.EAST, attackField, -10, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, enhanceField, 63, SpringLayout.SOUTH, attackField);
		appLayout.putConstraint(SpringLayout.EAST, enhanceField, -10, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, healthField, 63, SpringLayout.SOUTH, enhanceField);
		appLayout.putConstraint(SpringLayout.EAST, healthField, -10, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, imageLabel, 0, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, imageLabel, 0, SpringLayout.WEST, pokedexDropdown);
		appLayout.putConstraint(SpringLayout.SOUTH, imageLabel, 271, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.EAST, imageLabel, -479, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, changeButton, 509, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, changeButton, -560, SpringLayout.EAST, this);
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
