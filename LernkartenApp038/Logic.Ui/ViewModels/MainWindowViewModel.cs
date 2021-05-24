using De.HsFlensburg.LernkartenApp038.Logic.Ui.ViewModels.Common;
using De.HsFlensburg.LernkartenApp038.Logic.Ui.Wrapper;
using De.HsFlensburg.LernkartenApp038.Logic.Ui.ServiceBusMessages;
using De.HsFlensburg.LernkartenApp038.Services.MediatorServiceBus;
using De.HsFlensburg.LernkartenApp038;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections.ObjectModel;
using System.Data;
using System.Xml.Serialization;
using System.IO;

namespace De.HsFlensburg.LernkartenApp038.Logic.Ui.ViewModels
{
    public class MainWindowViewModel : AbstractViewModel
    {
        #region Properties
        public ListOfSetsViewModel Sets { get; set; }
        public SetViewModel CurrentSet { get; set; }
        public SetViewModel Set { get; set; }
        public CardViewModel Card { get; set; }
        public SetViewModel SelectedItem { get; set; }
        public CardViewModel SelectedCard { get; set; }
        public String NewSetName { get; set; }
        public String NewSetCategory { get; set; }
        public String NewCardName { get; set; }
        public String NewCardQuestion { get; set; }
        public String NewCardAnswer { get; set; }
        public RelayCommand CreateSetCommand { get; }
        public RelayCommand CreateCardCommand { get; }
        public RelayCommand SaveSetCommand { get; }
        public RelayCommand SaveListCommand { get; }
        public RelayCommand ResetListCommand { get; }
        public RelayCommand ResetSetCommand { get; }
        public RelayCommand RemoveSetCommand { get; }
        public RelayCommand RemoveCardCommand { get; }
        public RelayCommand OpenStatWindowCommand { get; }
        public RelayCommand OpenSetWindowCommand { get; }
        public RelayCommand OpenCardWindowCommand { get; }
        public RelayCommand OpenEmailWindowCommand { get; }
        public RelayCommand OpenLoginWindowCommand { get; }
        public RelayCommand OpenLernsessionWindowCommand { get; }
        public RelayCommand OpenPDFWindowCommand{ get; }
        #endregion

        internal ListOfSetsViewModel getListModel()
        {
            return Sets;
        }
        internal SetViewModel getSetModel()
        {
            return SelectedItem;
        }

        public MainWindowViewModel(ListOfSetsViewModel ListOfSets)
        {
            Sets = ListOfSets;
        }

        public MainWindowViewModel()
        {
            Sets = new ListOfSetsViewModel();
            SelectedItem = new SetViewModel();
            loadAllFiles();

            #region DefaultInputNames
            NewSetName = "Name Set";
            NewSetCategory = "Category Set";
            NewCardName = "Name Card";
            NewCardQuestion = "Question Card";
            NewCardAnswer = "Answer Card";
            #endregion


            #region RelayCommands
            CreateSetCommand = new RelayCommand(() => CreateSet());
            CreateCardCommand = new RelayCommand(() => CreateCard());
            RemoveSetCommand = new RelayCommand(() => Sets.Remove(SelectedItem));
            RemoveCardCommand = new RelayCommand(() => SelectedItem.Cards.Remove(SelectedCard));
            ResetListCommand = new RelayCommand(() => Sets.Clear());
            ResetSetCommand = new RelayCommand(() => SelectedItem.Cards.Clear());
            SaveSetCommand = new RelayCommand(() => SelectedItem.set.SerializeDataSetModel());
            SaveListCommand = new RelayCommand(() => SerializeDataList(Sets));
            OpenStatWindowCommand = new RelayCommand(() => OpenStatWindow());
            OpenSetWindowCommand = new RelayCommand(() => OpenSetWindow());
            OpenCardWindowCommand = new RelayCommand(() => OpenCardWindow());
            OpenPDFWindowCommand = new RelayCommand(() => OpenPDFWindow());
            OpenLernsessionWindowCommand = new RelayCommand(() => OpenLernsessionWindow());
            OpenEmailWindowCommand = new RelayCommand(() => OpenEmailWindow());
            OpenLoginWindowCommand = new RelayCommand(() => OpenLoginWindow());
            #endregion
        }

        private void OpenStatWindow()
        {
            ServiceBus.Instance.Send(new OpenStatisticsWindowMessage());
        }
        private void OpenSetWindow()
        {
            ServiceBus.Instance.Send(new OpenCreateSetWindowMessage(Sets));
        }
       
        private void OpenCardWindow()
        {
            ServiceBus.Instance.Send(new OpenCreateCardWindowMessage(SelectedItem));
        }
        private void OpenPDFWindow()
        {
            ServiceBus.Instance.Send(new OpenPDFExportWindowMessage());
        }
        private void OpenEmailWindow()
        {
            ServiceBus.Instance.Send(new OpenEmailWindowMessage());
        }
        private void OpenLoginWindow()
        {
            ServiceBus.Instance.Send(new OpenLoginWindowMessage());
        }
        private void OpenLernsessionWindow()
        {
            ServiceBus.Instance.Send(new OpenLernsessionWindowMessage());
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
        private void CreateCard()
        {
            try{
                Card = new CardViewModel();
                Card.Name = NewCardName;
                Card.Question = NewCardQuestion;
                Card.Answer = NewCardAnswer;
                SelectedItem.Cards.Add(Card);
                Console.WriteLine(SelectedItem.Cards.Count);
            }catch(Exception e)
            {
                Console.WriteLine(e.Message);
            }

        }

        private void SerializeDataSet(SetViewModel saveObject)
        {
            try
            {
                XmlSerializer ser = new XmlSerializer(saveObject.set.GetType());
                Console.WriteLine(saveObject.set + " " + saveObject.Name + " " + saveObject.Category);
                Console.WriteLine(saveObject.set.Name + " " + saveObject.set.Category);
                TextWriter writer = new StreamWriter(Environment.CurrentDirectory + "/Sets/" + saveObject.Name + ".xml");
                Console.WriteLine(writer+ "joo");
                ser.Serialize(writer, saveObject);
                writer.Close();
            }catch(Exception e)
            {
                Console.WriteLine(e.Data);
            }

        }

        private void SerializeDataList(ListOfSetsViewModel list)
        {
            foreach(SetViewModel svm in list)
            {
                svm.set.SerializeDataSetModel();
            }
        }

        protected void ReadSet(string filename)
        {
            // Create an instance of the XmlSerializer class;
            // specify the type of object to be deserialized.
            XmlSerializer serializer = new XmlSerializer(typeof(SetViewModel));
            /* If the XML document has been altered with unknown 
            nodes or attributes, handle them with the 
            UnknownNode and UnknownAttribute events.*/
            serializer.UnknownNode += new
            XmlNodeEventHandler(serializer_UnknownNode);
            serializer.UnknownAttribute += new
            XmlAttributeEventHandler(serializer_UnknownAttribute);

            // A FileStream is needed to read the XML document.
            FileStream fs = new FileStream(filename, FileMode.Open);
            // Declare an object variable of the type to be deserialized.
            SetViewModel po;
            /* Use the Deserialize method to restore the object's state with
            data from the XML document. */
            po = new SetViewModel((Business.Model.BusinessObjects.Set) serializer.Deserialize(fs));
            // Read the order date.
            Console.WriteLine("Set: " + po.Name);
            Sets.Add(po);
        }

        private void loadAllFiles()
        {
            string[] fileEntries = Directory.GetFiles(Environment.CurrentDirectory + "/Sets");
            foreach (string fileName in fileEntries)
            {
                SetViewModel loadedSet = new SetViewModel(fileName);
                //loadedSet.loadSet(fileName);
                Sets.Add(loadedSet);
            }
        }

        private void loadAllFilesFromSets()
        {
            string[] fileEntries = Directory.GetFiles(Environment.CurrentDirectory+"/Sets");
            XmlRootAttribute xRoot = new XmlRootAttribute();
            xRoot.Namespace = "www.test.com";
            xRoot.ElementName = "Set";
            xRoot.DataType = "xml";
            xRoot.IsNullable = true;            
            XmlSerializer serializer = new XmlSerializer(typeof(Business.Model.BusinessObjects.Set),xRoot);
            foreach (string fileName in fileEntries)
            {
                serializer.UnknownNode += new
                XmlNodeEventHandler(serializer_UnknownNode);
                serializer.UnknownAttribute += new
                XmlAttributeEventHandler(serializer_UnknownAttribute);

                // A FileStream is needed to read the XML document.
                FileStream fs = new FileStream(fileName, FileMode.Open);
                // Declare an object variable of the type to be deserialized.
                SetViewModel po = new SetViewModel();
                Business.Model.BusinessObjects.Set set = (Business.Model.BusinessObjects.Set)serializer.Deserialize(fs);

                foreach (var card in set.Cards)
                    po.Cards.Add(new CardViewModel(card));
                
                po.Name = set.Name;
                po.Category = set.Category;

                Sets.Add(po);
            }
        }

        private void serializer_UnknownNode
   (object sender, XmlNodeEventArgs e)
        {
            Console.WriteLine("Unknown Node:" + e.Name + "\t" + e.Text);
        }

        private void serializer_UnknownAttribute
        (object sender, XmlAttributeEventArgs e)
        {
            System.Xml.XmlAttribute attr = e.Attr;
            Console.WriteLine("Unknown attribute " +
            attr.Name + "='" + attr.Value + "'");
        }
    }
}
