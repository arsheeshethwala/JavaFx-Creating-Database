package codeMain;

/*
 * @ author - Arsheemahedi Shethwala
 * This is the database controller file with all the FXML variables declared and
 * all the methods to add, modify, delete items and load and save data to file. 
 */
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class DatabaseController extends Item implements config {

	// declaring variables from the FXML document
	@FXML
	TextField txtId, txtItem, txtQty, txtPrice;
	@FXML
	Button btnAdd, btnRemove, btnModify, btnLoad, btnSave;
	@FXML
	ListView<String> listView;

	ArrayList<Item> tempList = new ArrayList<Item>();

	int index;

	// method to add the items in the list view
	public void doAddItem(ActionEvent e) {
		try {
			int id = Integer.parseInt(txtId.getText());
			String item = txtItem.getText();
			int quantity = Integer.parseInt(txtQty.getText());
			double price = Double.parseDouble(txtPrice.getText());
			items.add(new Item(id, item, quantity, price));
			listView.getItems().clear();
			for (Item i : items)
				listView.getItems().add(i.toString());
		} catch (Exception ex) {
			Alert alert = new Alert(AlertType.WARNING, "Wrong Input, Try Again");
			alert.showAndWait();
		}
	} // end of the addition item method

	// method to modify item
	public void doModifyItem(ActionEvent e) {

		int id = Integer.parseInt(txtId.getText());
		String item = txtItem.getText();
		int quantity = Integer.parseInt(txtQty.getText());
		double price = Double.parseDouble(txtPrice.getText());

		items.get(index).setId(id);
		items.get(index).setItem(item);
		items.get(index).setQuantity(quantity);
		items.get(index).setPrice(price);

		doFileSave();
		doFileLoad();

	} // end of the modify item method

	// method to remove the item
	public void doRemoveItem(ActionEvent e) {

		for (int i = 0; i < items.size(); i++) {
			if (index == i)
				continue;
			else
				tempList.add(items.get(i));
		}
		items = tempList;
		doFileSave(); // calling the save file method
		doFileLoad(); // calling the load file method
	}// end of the remove method

	// method to load the file
	public void doFileLoad() {

		items.clear();

		listView.getItems().clear();

		File f = new File(file);
		try {
			if (!f.exists())
				f.createNewFile();
			Scanner lines = new Scanner(f);
			if (!lines.hasNextLine()) {
				Alert alert = new Alert(AlertType.INFORMATION,
						"data file is empty\nenter item details and click the save button");
				alert.showAndWait();
			} else {
				while (lines.hasNextLine()) {
					Scanner line = new Scanner(lines.nextLine());
					line.useDelimiter(":\\s*");
					items.add(new Item(line.nextInt(), line.next(), line.nextInt(), line.nextDouble()));
					line.close();
				}
			}
			lines.close();

			for (Item item : items)
				listView.getItems().add(item.toString());

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		listView.setOnMouseClicked(ex -> {
			index = listView.getSelectionModel().getSelectedIndex();
			if (index >= 0 && index < items.size()) {
				txtId.setText("" + items.get(index).getId());
				txtItem.setText(items.get(index).getItem());
				txtQty.setText("" + items.get(index).getQuantity());
				txtPrice.setText("" + items.get(index).getPrice());
			}
		});

	} // end of the load file method

	// method to save the data to the file
	public void doFileSave() {

		File f = new File(file);
		try {

			if (!f.exists())
				f.createNewFile();
			PrintWriter pw = new PrintWriter(f);

			for (Item c : items)
				pw.append(c.getId() + ":" + c.getItem() + ":" + c.getQuantity() + ":" + c.getPrice() + "\n");
			pw.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}// end of the save data file method

} // end of the class
