using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml;
using System.Xml.Serialization;
using System.Threading.Tasks;
using De.HsFlensburg.LernkartenApp038.Business.Model.BusinessObjects;

namespace De.HsFlensburg.LernkartenApp038.Logic.Ui.Wrapper
{
    [XmlType("CardViewModel")]
    [Serializable]
    public class CardViewModel
    {
        public Card card { get; set; }


        public CardViewModel()
        {
            this.card = new Card();
        }
        public CardViewModel(Card card)
        {
            this.card = card;
        }
        [XmlAttribute]
        public String Name
        {
            get
            {
                return card.Name;
            }
            set
            {
                card.Name = value;
            }
        }
        [XmlAttribute]
        public String Question
        {
            get
            {
                return card.Question;
            }
            set
            {
                card.Question= value;
            }
        }
        [XmlAttribute]
        public String Answer
        {
            get
            {
                return card.Answer;
            }
            set
            {
                card.Answer= value;
            }
        }

        [XmlAttribute]
        public Boolean Correct
        {
            get
            {
                return card.Correct;
            }
            set
            {
                card.Correct = value;
            }
        }
    }
}
