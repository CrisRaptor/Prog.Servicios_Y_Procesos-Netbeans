using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Windows.Forms;

namespace VentasCoches_v3
{
    public partial class Form1 : Form
    {
        Boolean isEnabled = false;
        //Cars with Name and Price (€)
        List<Component> cars = new List<Component>() { 
            new Component("Ceed",25000),
            new Component("Niro",35000),
            new Component("Picanto",15000),
            new Component("Sportage",35000)};
        //Extras with Name and Price (€)
        List<Component> extras = new List<Component>() {
            new Component("Audio Bose",700),
            new Component("Bizona",650),
            new Component("Camara trasera",350) , 
            new Component("Sensores",450),
            new Component("Cuero",1200), 
            new Component("Control. velocidad",320),
            new Component("Cambio carril",400),
            new Component("GPS", 600), 
            new Component("Llantas 18\"", 1000), 
            new Component("Asist. aparcamiento", 500), 
            new Component("Cambio Automatico", 1100), 
            new Component("Android", 250), 
            new Component("CR7 Asistente", 300), 
            new Component("Asientos calefactores", 400)};
        //Discount codes with Name and Discount (Percent scale 0.01:1)
        List<Component> discounts = new List<Component>() {
            new Component("MOTOR",250),
            new Component("WHEEL",350),
            new Component("RUEDA",200),
            new Component("SEATS",200),
            new Component("NADAL",500),
            new Component("TRUNK",300)};

        public Form1()
        {
            InitializeComponent();
            //Load comboBox1 "Marcas" options
            foreach (Component co in cars)
            {
                comboBox1.Items.Add(co.Name);
            }
        }

    //Component funtions

        //Return Name from selected GridView values to listBox1 
        private void leftButton_Click(object sender, EventArgs e)
        {
            string item;
            foreach (DataGridViewRow row in dataGridView3.SelectedRows)
            {
                //Add GridView selected Items to listBox
                item = row.Cells[0].Value.ToString();
                listBox1.Items.Add(item);
                //Remove GridView selected Items
                dataGridView3.Rows.RemoveAt(row.Index);
                //Substract the Item Prices from textBox "Extras"
                textBox2.Text = Convert.ToString(Convert.ToInt32(textBox2.Text) - extras.First(i => i.Name.Equals(item)).Price);
                
            }
        }
        
        //Insert selected listBox1 Items on GridView with Price
        private void rightButton_Click(object sender, EventArgs e)
        {
            List<string> values = new List<string>();
            //Add items to GridView
            foreach (int index in listBox1.SelectedIndices)
            {
                string itemName = listBox1.Items[index].ToString();
                //Add selected items
                dataGridView3.Rows.Add(itemName, extras.First(i => i.Name.Equals(itemName)).Price);
                //Add item Price to "Extras" textBox
                textBox2.Text = Convert.ToString(Convert.ToInt32(textBox2.Text)+extras.First(i => i.Name.Equals(itemName)).Price);
                //Save item for remove
                values.Add(itemName.ToString());
            }
            //Remove items from listBox1
            foreach (String c in values)
            {
                //Remove at listBox1 items added on GridView
                listBox1.Items.Remove(c);
            }
        }

        //Load Extras ListBox on "Marca" change
        private void comboBox1_SelectedIndexChanged_1(object sender, EventArgs e)
        {
            //Reset Values
            listBox1.Items.Clear();
            dataGridView3.Rows.Clear();

            //Enabled all other components on fist comboBox change
            if (!isEnabled)
            {
                textBox1.Enabled = true;
                flowLayoutPanel1.Enabled = true;
                flowLayoutPanel6.Enabled = true;
                tableLayoutPanel2.Enabled = true;
                tableLayoutPanel3.Enabled = true;

                numericUpDown1.Enabled = true;
                dateTimePicker1.Enabled = true;
                groupBox1.Enabled = true;
                //listBox1.Enabled = true;
                //dataGridView3.Enabled = true;
                //listBox3.Enabled = true;
                //rightButton.Enabled = true;
                //leftButton.Enabled = true;
                //dataGridView3.Enabled = true;
                //checkBox1.Enabled = true;
                //textBox2.Enabled = true;
                //textBox5.Enabled = true;
                //textBox6.Enabled = true;
                //textBox7.Enabled = true;
                //textBox8.Enabled = true;
                //textBox9.Enabled = true;
                //textBox10.Enabled = true;
                //textBox11.Enabled = true;
                isEnabled = true;
            }

            //Load Extras and Image
            switch (comboBox1.SelectedIndex)
            {
                case 0:
                    loadListData(listBox1, extras, 4);
                    pictureBox1.Image = Properties.Resources.ceed_520x260;
                    break;
                case 1:
                    loadListData(listBox1, extras, 7);
                    pictureBox1.Image = Properties.Resources.niro_hev_520x260;
                    break;
                case 2:
                    loadListData(listBox1, extras, 11);
                    pictureBox1.Image = Properties.Resources.picanto_520x260;
                    break;
                case 3:
                    loadListData(listBox1, extras, 14);
                    pictureBox1.Image = Properties.Resources.sportage_520x260;
                    break;
                default:
                    break;
            }

            //Set car Price
            textBox6.Text = cars[comboBox1.SelectedIndex].Price.ToString();
        }

        //Sección Descuentos
        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            if (textBox1.Text.Length != 5)
            {
                //Red on incorrect format
                textBox1.ForeColor = Color.Red;
            }
            else
            {
                //Black on correct format
                textBox1.ForeColor = Color.Black;
            }
        }

        //Discount TextBox writing function
        private void textBox1_KeyPress(object sender, KeyPressEventArgs e)
        {
            //Accept only "Letter" and "Back" keyPresses
            e.Handled = !(char.IsLetter(e.KeyChar) || e.KeyChar == (char)Keys.Back);
        }

        //Discount TextBox Enter function
        private void textBox1_KeyDown(object sender, KeyEventArgs e)
        {
            //Accept only Enter on keyDown
            if (e.KeyCode == Keys.Enter)
            {
                //Check valid format
                if (textBox1.Text.Length == 5 && listBox3.Items.Count < 3)
                {
                    //Insert valid Text and reset textBox1 and errorProvider
                    if (discounts.Exists(i => i.Name.Equals(textBox1.Text)))
                    {
                        listBox3.Items.Add(textBox1.Text);
                        setDiscounts();
                        textBox1.Clear();
                        errorProvider1.Clear();
                    } else
                    {
                        errorProvider1.SetError(textBox1, "Code not available");
                    }
                    
                }
                else
                {
                    //Show errorProvider with respective help message
                    String errorMessage = ((textBox1.Text.Length != 5) ? "Obligatory 5 characters" : "Maximum 3 discounts");
                    errorProvider1.SetError(textBox1, errorMessage);
                }
            }
        }

        //Discount ListBox Delete function
        private void listBox3_KeyDown(object sender, KeyEventArgs e)
        {
            //Remove when pressing "Delete" key
            if (e.KeyCode == Keys.Delete)
            {
                listBox3.Items.Remove(listBox3.SelectedItem);
                setDiscounts();
            }
        }

        //"Intereses" checkbox
        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {
            textBox3.Enabled = checkBox1.Checked;
            textBox4.Enabled = checkBox1.Checked;
            numericUpDown2.Enabled = checkBox1.Checked;
            textBox8.Enabled = checkBox1.Checked;
            if (checkBox1.Checked)
            {
                setIntereses();
            }
            setPrice();
        }
        //"Numero de puertas" numericUpDown
        private void numericUpDown2_ValueChanged(object sender, EventArgs e)
        {
            setIntereses();
            setPrice();
        }

        //"Cuota" textBox limiting Price to "Precio Completo" value
        private void textBox4_TextChanged(object sender, EventArgs e)
        {
            if (Convert.ToInt32(textBox4.Text) > Convert.ToInt32(textBox9.Text))
            {
                textBox4.Text = textBox9.Text;
            }
        }

        //Compute "Base Imponible" when "Extras" or "Precio Coche" changes
        private void textBox2_TextChanged(object sender, EventArgs e)
        {
            textBox5.Text = Convert.ToString(Convert.ToInt32(textBox2.Text) + Convert.ToInt32(textBox6.Text));
            if (checkBox1.Checked) {
                setIntereses();
            }
            setIva();
            setPrice();
        }
        private void textBox6_TextChanged(object sender, EventArgs e)
        {
            textBox5.Text = Convert.ToString(Convert.ToInt32(textBox2.Text) + Convert.ToInt32(textBox6.Text));
            if (checkBox1.Checked)
            {
                setIntereses();
            }
            setIva();
            setPrice();
        }

        //Other functions
        
        //Load Component Names to a listBox
        private void loadListData(ListBox objeto, List<Component> lista, int cantidad)
        {
            for (int i = 0; i < cantidad; i++)
            {
                objeto.Items.Add(lista[i].Name);
            }
        }

        //Return a double and asigns it to "Intereses"(%) textBox
        private double setIntereses()
        {
            double value = 2 + ((0.01) * (double)numericUpDown2.Value) + (0.5*((Convert.ToInt32(textBox6.Text)/10000)));
            textBox3.Text = value.ToString();
            textBox8.Text = ((int)(Convert.ToInt32(textBox5.Text)*(value/100))).ToString();
            return value;
        }

        //Set the IVA value of "Base imponible"
        private int setIva()
        {
            int value = (int)(Convert.ToInt32(textBox5.Text) * 0.21);
            textBox7.Text = value.ToString();
            return value;
        }

        //Compute and set the "Precio Completo" textBox
        private int setPrice()
        {
            int value;
            if (checkBox1.Checked)
            {
                value = Convert.ToInt32(textBox5.Text) + Convert.ToInt32(textBox7.Text) + Convert.ToInt32(textBox8.Text);
            } else
            {
                value = Convert.ToInt32(textBox5.Text) + Convert.ToInt32(textBox7.Text);
            }
            textBox9.Text = value.ToString();
            setTotal();
            return value;
        }

        //Compute and set the "Discount" percent a value (€)
        private int setDiscounts()
        {
            int percent = 0;
            int value = 0;
            Component discount;
            if (listBox3.Items.Count > 0)
            {
                foreach (string code in listBox3.Items)
                {
                    discount = discounts.First(i => i.Name.Equals(code));
                    percent += discount.Price;
                    //Compute discount in %
                    textBox10.Text = (percent / 100.0).ToString();
                    //Set discount in €
                    value = (Convert.ToInt32(textBox5.Text) * percent / 100);
                    textBox12.Text = "-" + (value / 100).ToString();
                }
            } else
            {
                textBox10.Text = "0";
                textBox12.Text = "0";
            }
            setTotal();
            return value;
        }

        //Compute and set the "TOTAL" textBox
        private int setTotal()
        {
            int value = Convert.ToInt32(textBox9.Text) + Convert.ToInt32(textBox12.Text);
            textBox11.Text = value.ToString();
            return value;
        }
    }
}