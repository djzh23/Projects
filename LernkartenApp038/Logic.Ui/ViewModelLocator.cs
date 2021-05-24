using De.HsFlensburg.LernkartenApp038.Logic.Ui.ViewModels;
using De.HsFlensburg.LernkartenApp038.Logic.Ui.Wrapper;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace De.HsFlensburg.LernkartenApp038.Logic.Ui
{
    public class ViewModelLocator
    {
        public ViewModelLocator()
        {
            int variante = 0;

            if (variante == 0)
            {
                #region Variante1: Erzegung des Models im MainWindowViewModel
                // MainWindow wird erzeugt - und darin das Model...
                MainWindowVM = new MainWindowViewModel();
                // Das Model geholt...
                ListOfSetsViewModel losvm = MainWindowVM.getListModel();
                SetViewModel svm = MainWindowVM.getSetModel();
                // und allen weiteren ViewModels übergeben:
                CreateSetWindowVM = new CreateSetViewModel(losvm);
                CreateCardWindowVM = new CreateCardViewModel(svm);
                LoginWindowVM = new LoginViewModel(losvm);
                ShareEmailVM = new ShareEmailViewModel(losvm); 
                #endregion
            }
            else
            
            {
                #region Variante2: Erzegung des Models im ViewModelLocator
                // Das Model wird erzeugt
                ListOfSetsViewModel losvm = new ListOfSetsViewModel();
                // und allen  ViewModels übergeben:
                MainWindowVM = new MainWindowViewModel(losvm);
               // StatisticWindowVM = new StatisticsWindowViewModel(losvm);
                #endregion
            }

        }
        // ToDo: Inhalte für Vorlesung: Achtung: diese Properties 
        // müssen Public sein, da sie von XMAL aus referenziert werden! 
        // Compiler erwartet nur internal...
        public MainWindowViewModel MainWindowVM { get; }
        public CreateSetViewModel CreateSetWindowVM { get; }
        public CreateCardViewModel CreateCardWindowVM { get; }
        public LoginViewModel LoginWindowVM { get; }
        public ShareEmailViewModel ShareEmailVM { get;  }
    }
}
