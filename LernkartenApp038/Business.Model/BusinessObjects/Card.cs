using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml;
using System.Xml.Serialization;
using System.Threading.Tasks;

namespace De.HsFlensburg.LernkartenApp038.Business.Model.BusinessObjects
{
    [XmlType("Card")]
    [Serializable]
    public class Card 
    {
        [XmlAttribute]
        public String Name { get; set; }
        [XmlAttribute]
        public String Question { get; set; }
        [XmlAttribute]
        public String Answer { get; set; }
        [XmlAttribute]
        public Boolean Correct { get; set; }
    }
}
