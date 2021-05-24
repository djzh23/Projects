using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace De.HsFlensburg.LernkartenApp038.Logic.Ui.ServiceBusMessages
{
    public class OpenCreateSetWindowMessage
    {
        public OpenCreateSetWindowMessage() { }

        public OpenCreateSetWindowMessage(object temp)
        {
            this.Temp = temp;
        }
        public object Temp { get; set; }
    }
}
