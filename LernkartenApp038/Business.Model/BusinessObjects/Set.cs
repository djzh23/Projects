using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml;
using System.Xml.Serialization;
using System.Threading.Tasks;
using System.Collections.ObjectModel;
using System.IO;

namespace De.HsFlensburg.LernkartenApp038.Business.Model.BusinessObjects
{
    [XmlRoot(Namespace = "www.test.com",
     ElementName = "Set",
     DataType = "xml",
     IsNullable = true)]
    [Serializable]
    public class Set
    {
        [XmlElement]
        private ObservableCollection<Card> cards;
        public Set()
        {
             this.cards = new ObservableCollection<Card>();
        }
        public Set(Set set)
        {
            this.Name = set.Name;
            this.Category = set.Category;
            this.cards = set.Cards;
        }
        [XmlElement]
        public String Name { get; set; }
        [XmlElement]
        public String Category { get; set; }
        public ObservableCollection<Card> Cards
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
        public void SerializeDataSetModel()
        {
            try
            {
                /*XmlRootAttribute xRoot = new XmlRootAttribute();
                xRoot.ElementName = "Set";
                xRoot.Namespace = "http://www.kalla.com";
                xRoot.IsNullable = true;*/
                
                XmlSerializer ser = new XmlSerializer(typeof(Set));
                
                TextWriter writer = new StreamWriter(Environment.CurrentDirectory + "/Sets/" + this.Name + ".xml");
                ser.Serialize(writer, this);
                writer.Close();
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Data);
            }

        }
    }
}
