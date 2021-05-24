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

namespace De.HsFlensburg.LernkartenApp038.Ui.Desktop
{
    /// <summary>
    /// Interaktionslogik für Lernsession.xaml
    /// </summary>
    public partial class Lernsession : Window
    {
        public Lernsession()
        {
            InitializeComponent();
        }

        private void giveAnswer(object sender, RoutedEventArgs e)
        {
            if (answer.Visibility == Visibility.Hidden)
            {
                answer.Visibility = Visibility.Visible;
            }
            else
            {
                answer.Visibility = Visibility.Hidden;
            }
        }
    }
}
