using De.HsFlensburg.LernkartenApp038.Logic.Ui.ServiceBusMessages;
using De.HsFlensburg.LernkartenApp038.Logic.Ui.Wrapper;
using De.HsFlensburg.LernkartenApp038.Services.MediatorServiceBus;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace De.HsFlensburg.LernkartenApp038.Logic.Ui.ViewModels
{
    public class CreateSetViewModel
    {
        private ListOfSetsViewModel Sets { get; set; }
        private SetViewModel Set { get; set; }
        public String NewSetName { get; set; }
        public String NewSetCategory { get; set; }
        public RelayCommand CreateSetCommand { get; }
        public RelayCommand EMAIL { get; }

        public CreateSetViewModel()
        {
            CreateSetCommand = new RelayCommand(() => CreateSet());

            //EMAIL = new RelayCommand(() => OpenEmailWindow());
        }

        public CreateSetViewModel(ListOfSetsViewModel Sets)
        {
            this.Sets = Sets;
            CreateSetCommand = new RelayCommand(() => CreateSet());

            EMAIL = new RelayCommand(() => OpenEmailWindow());
        }

        private void OpenEmailWindow()
        {
            ServiceBus.Instance.Send(new OpenEmailWindowMessage());
        }

        private void CreateSet()
        {
            try
            {
                Set = new SetViewModel();
                Set.Name = NewSetName;
                Set.Category = NewSetCategory;
                Sets.Add(Set);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }
    }
}
