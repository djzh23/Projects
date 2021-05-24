using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace De.HsFlensburg.LernkartenApp038.Services.MediatorServiceBus
{
    interface IServiceBus
    {
        void Register<TNotification>(object listener, Action<TNotification> action);
        void Send<TNotification>(TNotification notification);
        void Unregister<TNotification>(object listener);
    }
}
