using De.HsFlensburg.LernkartenApp038.Services.MediatorServiceBus;
using De.HsFlensburg.LernkartenApp038.Logic.Ui.ViewModels;
using De.HsFlensburg.LernkartenApp038.Logic.Ui.Wrapper;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using De.HsFlensburg.LernkartenApp038.Logic.Ui.ServiceBusMessages;

namespace De.HsFlensburg.LernkartenApp038.Ui.Desktop
{
    class MessageListener
    {
        public MessageListener()
        {
            InitMessenger();
        }

        #region methods

        private void InitMessenger()
        {
            ServiceBus.Instance.Register<OpenStatisticsWindowMessage>(
                this,
                msg =>
                {
                    Statistics window = new Statistics();
                    window.Show();
                });

            ServiceBus.Instance.Register<OpenCreateSetWindowMessage>(
                this,
                msg =>
                {
                    CreateSet window = new CreateSet();
                    window.Show();
                });

            ServiceBus.Instance.Register<OpenCreateCardWindowMessage>(
                this,
                msg =>
                {
                    CreateCard window = new CreateCard();
                    window.Show();
                });

            ServiceBus.Instance.Register<OpenLernsessionWindowMessage>(
                this,
                msg =>
                {
                    Lernsession window = new Lernsession();
                    window.Show();
                });

            ServiceBus.Instance.Register<OpenEmailWindowMessage>(
                this,
                msg =>
                {
                    ShareEmail window = new ShareEmail();
                    window.Show();
                });
            ServiceBus.Instance.Register<OpenLoginWindowMessage>(
                this,
                msg =>
                {
                    Login window = new Login();
                    window.Show();
                });

            ServiceBus.Instance.Register<OpenPDFExportWindowMessage>(
                this,
                msg =>
                {
                    ShareEmail window = new ShareEmail();
                    window.Show();
                });

        }


        #endregion

        #region properties

    //  Damit diese Property gebindet werden kann, muss zunächst 
    //  diese Klasse als Static Resource der App.xaml hinzugefügt werden:

        //<Application.Resources>
        //<desktop:MessageListener x:Key="MessageListener">
        //</desktop:MessageListener>
        //</Application.Resources>
        //</Application>

            // Dann muss nur noch die Property an die IsEnabled-Eigenschaft gebindet werden,
            // damit eine Instanz von dieser Klasse erzeugt wird:

    //  <Window.IsEnabled>
    //          <Binding Source = "{StaticResource MessageListener}" Path="BindableProperty"></Binding>
    //  </Window.IsEnabled>

            // Und nur dafür ist diese Property... :
        public bool BindableProperty => true;

        #endregion
    }
}
