using De.HsFlensburg.LernkartenApp038.Logic.Ui.Wrapper;
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
    /// Interaktionslogik für CreateCard.xaml
    /// </summary>
    public partial class CreateSet : Window
    {
        public CreateSet()
        {
            InitializeComponent();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            List<SetViewModel> list = new List<SetViewModel>();
            SetViewModel setviewmodel = new SetViewModel();
            setviewmodel.Name = name_input.Text;
            setviewmodel.Category = category_input.Text;
            Console.WriteLine(setviewmodel.Name + " " + setviewmodel.Category);
        }

       
    }
}
