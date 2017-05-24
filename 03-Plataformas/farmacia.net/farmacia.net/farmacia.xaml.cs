using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace farmacia.net
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void TextBox_TextChanged(object sender, TextChangedEventArgs e)
        {

        }

        private void TextBox_TextChanged_1(object sender, TextChangedEventArgs e)
        {

        }

        private void RadioButton_Checked(object sender, RoutedEventArgs e)
        {

        }

        private void tipoMedicamento_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {

        }

        private void borrarBtn_Click(object sender, RoutedEventArgs e)
        {
            nombreMedicamento.Clear();
            tipoMedicamento.SelectedIndex = -1;
            cantidad.Clear();
            distribuidorRdb.IsChecked = false;
            distribuidorRdb1.IsChecked = false;
            distribuidorRdb2.IsChecked = false;
            principalChk.IsChecked = false;
            secundariaChk.IsChecked = false;
        }

        private void okBtn_Click(object sender, RoutedEventArgs e)
        {
            String titulo = "Pedido al distribuidor";
            if (distribuidorRdb.IsChecked == true) {
                titulo += " " + distribuidorRdb.Content;
            } else if (distribuidorRdb1.IsChecked == true) {
                titulo += " " + distribuidorRdb1.Content;
            } else if (distribuidorRdb2.IsChecked == true) {
                titulo += " " + distribuidorRdb2.Content;
            }
            String texto = cantidad.Text + " unidades del " + ((ComboBoxItem)tipoMedicamento.SelectedItem).Content.ToString() + " " + nombreMedicamento.Text;
            texto += "\n\nPara la Farmacia ";
            if (principalChk.IsChecked == true)
            {
                texto += "PRINCIPAL situada en la Avenida Siempreviva 723";
            }
            if (principalChk.IsChecked == true && secundariaChk.IsChecked == true)
            {
                texto += " y ";
            }
            if (secundariaChk.IsChecked == true)
            {
                texto += "SECUNDARIA situada en la Avenida Rivadavia 4578";
            }
            pedido winpedido = new pedido(titulo, texto);
            winpedido.Show();
        }
    }
}
