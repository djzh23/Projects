using De.HsFlensburg.LernkartenApp038.Logic.Ui.Wrapper;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace De.HsFlensburg.LernkartenApp038.Logic.Ui.ViewModels
{
    public class CreateCardViewModel
    {
        private SetViewModel Set { get; set; }
        private CardViewModel Card { get; set; }
        public String NewCardName { get; set; }
        public String NewCardQuestion { get; set; }
        public String NewCardAnswer { get; set; }
        public RelayCommand CreateCardCommand { get; }

        public CreateCardViewModel()
        {
            CreateCardCommand = new RelayCommand(() => CreateCard());
        }

        public CreateCardViewModel(SetViewModel Set)
        {
            this.Set = Set;
            Console.WriteLine(this.Set + " abc");
            CreateCardCommand = new RelayCommand(() => CreateCard());
        }

        private void CreateCard()
        {
            try
            {
                Card = new CardViewModel();
                Card.Name = NewCardName;
                Card.Question = NewCardQuestion;
                Card.Answer = NewCardAnswer;
                this.Set.Cards.Add(Card);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }
    }
}
