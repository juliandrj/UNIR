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
using System.Windows.Shapes;

namespace farmacia.net
{
    /// <summary>
    /// Lógica de interacción para pedido.xaml
    /// </summary>
    public partial class pedido : Window
    {
        public pedido()
        {
            InitializeComponent();
        }

        public pedido(String titulo, String texto) {
            InitializeComponent();
            this.Title = titulo;
            this.textoPedido.Content = texto;
        }
    }
}
