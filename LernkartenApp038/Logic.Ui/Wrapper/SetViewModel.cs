using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;
using System.Xml.Serialization;
using De.HsFlensburg.LernkartenApp038.Business.Model.BusinessObjects;
using System.Collections.ObjectModel;
using De.HsFlensburg.LernkartenApp038.Logic.Ui.ViewModels.Common;
using System.Collections.Specialized;
using System.IO;

namespace De.HsFlensburg.LernkartenApp038.Logic.Ui.Wrapper

{
    [XmlType("SetViewModel")]
    [Serializable]
    public class SetViewModel
    {
        public Set set;
        [XmlElement]
        private ObservableCollection<CardViewModel> cards;
        private bool syncDisabled = false;

        public SetViewModel()
        {
            this.set = new Set();
            this.cards = new ObservableCollection<CardViewModel>();

            this.cards.CollectionChanged += ViewModelCollectionChanged;
            this.set.Cards.CollectionChanged += ModelCollectionChanged;
        }
        public SetViewModel(Set set)
        {
            this.set = new Set(set);
            this.cards = new ObservableCollection<CardViewModel>();
            // this.set.Name = set.Name;
            //this.set.Category = set.Category;
            //this.set.Cards = set.Cards;


            this.cards.CollectionChanged += ViewModelCollectionChanged;
            this.set.Cards.CollectionChanged += ModelCollectionChanged;
        }
        [XmlAttribute]
        public string Name
        {
            get
            {
                return set.Name;
            }
            set
            {
                set.Name = value;
            }
        }
        [XmlAttribute]
        public string Category
        {
            get
            {
                return set.Category;
            }
            set
            {
                set.Category = value;
            }
        }

        public ObservableCollection<CardViewModel> Cards
        {
            get
            {
                return this.cards;
            }
            set
            {
                this.cards = value;
            }
        }


        private void ViewModelCollectionChanged(object sender, NotifyCollectionChangedEventArgs e)
        {
            if (syncDisabled) return;
            syncDisabled = true;
            Console.WriteLine(this);

            switch (e.Action)
            {
                case NotifyCollectionChangedAction.Add:
                    foreach (var card in e.NewItems.OfType<CardViewModel>().Select(v => v.card).OfType<Card>())
                        this.set.Cards.Add(card);
                    break;
                case NotifyCollectionChangedAction.Remove:
                    foreach (var card in e.OldItems.OfType<CardViewModel>().Select(v => v.card).OfType<Card>())
                        this.set.Cards.Remove(card);
                    break;
                case NotifyCollectionChangedAction.Reset:
                    this.set.Cards.Clear();
                    break;
            }
            syncDisabled = false;
        }

        private void ModelCollectionChanged(object sender, NotifyCollectionChangedEventArgs e)
        {
            if (syncDisabled) return;
            syncDisabled = true;

            switch (e.Action)
            {
                case NotifyCollectionChangedAction.Add:
                    foreach (var card in e.NewItems.OfType<Card>())
                        this.cards.Add(new CardViewModel(card));
                    break;
                case NotifyCollectionChangedAction.Remove:
                    foreach (var card in e.OldItems.OfType<Card>())
                        this.cards.Remove(GetViewModelOfModel(card));
                    break;
                case NotifyCollectionChangedAction.Reset:
                    this.cards.Clear();
                    break;
            }
            syncDisabled = false;
        }

        private CardViewModel GetViewModelOfModel(Card card)
        {
            foreach (CardViewModel cvm in this.Cards)
            {
                if (cvm.card.Equals(card)) return cvm;
            }
            return null;
        }

        public SetViewModel(String fileName)
        {
            this.set = new Set();
            this.cards = new ObservableCollection<CardViewModel>();
            this.cards.CollectionChanged += ViewModelCollectionChanged;
            this.set.Cards.CollectionChanged += ModelCollectionChanged;

            XmlRootAttribute xRoot = new XmlRootAttribute();
            xRoot.Namespace = "www.test.com";
            xRoot.ElementName = "Set";
            xRoot.DataType = "xml";
            xRoot.IsNullable = true;

            FileStream fs = new FileStream(fileName, FileMode.Open);
            XmlSerializer serializer = new XmlSerializer(typeof(Set), xRoot);
            /*
            serializer.UnknownNode += new
            XmlNodeEventHandler(serializer_UnknownNode);
            serializer.UnknownAttribute += new
            XmlAttributeEventHandler(serializer_UnknownAttribute);*/

            Set set = (Set)serializer.Deserialize(fs);
            foreach (var card in set.Cards)
                this.Cards.Add(new CardViewModel(card));

                //this.set.Cards.Add(card);
            this.Name = set.Name;
            this.Category = set.Category;

            
        }
        

    }
}

